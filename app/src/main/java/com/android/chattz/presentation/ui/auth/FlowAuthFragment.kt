package com.android.chattz.presentation.ui.auth

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.android.chattz.R
import com.android.chattz.presentation.base.BaseFlowFragment
import com.android.chattz.presentation.extesions.hideActionBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlowAuthFragment:BaseFlowFragment(R.layout.fragment_flow_auth,R.id.fragment_container_view){

    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
        NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
    }
}