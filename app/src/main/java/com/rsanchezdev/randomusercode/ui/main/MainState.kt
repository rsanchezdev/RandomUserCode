package com.rsanchezdev.randomusercode.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.rsanchezdev.domain.dto.user.User
import com.rsanchezdev.domain.dto.Error
import com.rsanchezdev.randomusercode.R

fun Fragment.buildMainState(
    context: Context = requireContext(),
    navController: NavController = findNavController()
) = MainState(context, navController)

class MainState(
    private val context: Context,
    private val navController: NavController
) {
    fun onUserClicked(user: User) {
/*        val action = MainFragmentDirections.actionMainToDetail(user)
        navController.navigate(action)*/
    }

    fun errorToString(error: Error) = when (error) {
        is Error.Connectivity -> context.getString(R.string.connectivity_error)
        is Error.Server -> context.getString(R.string.server_error, error.code.toString())
        is Error.Unknown -> context.getString(R.string.unknown_error, error.message)
    }

}