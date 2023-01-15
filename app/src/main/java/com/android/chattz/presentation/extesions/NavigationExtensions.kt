package com.android.chattz.presentation.extesions

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.chattz.R

fun Fragment.activityNavController() = requireActivity().findNavController(R.id.fragment_container_view)

fun Fragment.flowNavController(@IdRes navHostId: Int) = requireActivity().findNavController(
    navHostId
)

fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}
fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}

fun Fragment.overrideOnBackPressed(onBackPressed: OnBackPressedCallback.() -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}

fun Fragment.childCurrentBack(@IdRes container:Int){
    val navController =  Navigation.findNavController(requireActivity(),container)
    NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
}