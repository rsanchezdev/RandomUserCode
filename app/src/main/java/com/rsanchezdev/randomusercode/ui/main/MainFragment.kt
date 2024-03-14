package com.rsanchezdev.randomusercode.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rsanchezdev.randomusercode.R
import com.rsanchezdev.randomusercode.data.launchAndCollect
import com.rsanchezdev.randomusercode.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var mainState: MainState

    private val adapter = UsersListAdapter { mainState.onUserClicked(it) }

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding

    private lateinit var searchView: SearchView

    private var viewCreated = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainState = buildMainState()

        _binding = FragmentMainBinding.bind(view).apply {
            rvUsersList.adapter = adapter
        }

        configureSearchView()

        viewLifecycleOwner.launchAndCollect(viewModel.state) {
            binding.loading = it.loading
            binding.users = it.requestedItems.items
            binding.error = it.requestedItems.error?.let(mainState::errorToString)
        }

        if (!viewCreated){
            viewCreated = true
            viewModel.onUiReady()
        }
    }

    private fun configureSearchView(){
        binding.toolbar.inflateMenu(R.menu.main_search_view_menu)

        searchView = binding.toolbar.menu.findItem(R.id.searchAction).actionView as SearchView
        searchView.setOnCloseListener {
            binding.users = viewModel.getUserListFiltered()
            false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                binding.users = viewModel.getUserListFiltered(msg)
                return false
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if (!searchView.isIconified){
            searchView.isIconified = true
        }
    }
}