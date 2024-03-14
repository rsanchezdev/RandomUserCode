package com.rsanchezdev.randomusercode.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rsanchezdev.domain.dto.user.User
import com.rsanchezdev.randomusercode.R
import com.rsanchezdev.randomusercode.databinding.FragmentMainUserRowBinding
import com.rsanchezdev.randomusercode.ui.common.basicDiffUtil
import com.rsanchezdev.randomusercode.ui.common.inflate

class UsersListAdapter(private val listener: (User) -> Unit) :
    ListAdapter<User, UsersListAdapter.ViewHolder>(basicDiffUtil { old, new -> old.phone == new.phone }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.fragment_main_user_row, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user, listener(user))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = FragmentMainUserRowBinding.bind(view)
        fun bind(user: User, listener: Unit) {
            binding.user = user
            binding.userName = "${user.name.first} ${user.name.last}"
            binding.ivRowBtn.setOnClickListener { listener }
        }
    }
}