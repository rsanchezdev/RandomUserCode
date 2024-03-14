package com.rsanchezdev.randomusercode.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rsanchezdev.randomusercode.R
import com.rsanchezdev.randomusercode.data.launchAndCollect
import com.rsanchezdev.randomusercode.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        const val female = "female"
        const val dateFormat = "dd/MM/yyyy"
    }

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var _binding: FragmentDetailBinding
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDetailBinding.bind(view)

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        viewLifecycleOwner.launchAndCollect(viewModel.state) { state ->
            state.user?.let { user ->
                binding.userName = "${user.name.first} ${user.name.last}"
                binding.gender = requireContext().getString(if (user.gender == female) R.string.gender_female else R.string.gender_male)
                binding.date = getFormattedDate(user.registered.date)
                binding.user = user
            }
        }
    }

    private fun getFormattedDate(date: Date): String {
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
        return simpleDateFormat.format(date)
    }
}