package com.android.chattz.presentation.ui.main

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.android.chattz.R
import com.android.chattz.presentation.base.BaseFlowFragment
import com.android.chattz.presentation.extesions.hideActionBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlowMainFragment:BaseFlowFragment(R.layout.fragment_flow_main,R.id.fragment_container_view){

    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
        NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
    }
}