package com.rsanchezdev.randomusercode.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rsanchezdev.domain.dto.user.User

@BindingAdapter("items")
fun RecyclerView.setItems(users: List<User>?) {
    users?.let {
        (adapter as? UsersListAdapter)?.submitList(users)
    }
}