package com.android.chattz.presentation.ui.main

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chattz.R
import com.android.chattz.databinding.FragmentFlowMainBinding
import com.android.chattz.presentation.base.BaseFlowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlowMainFragment:BaseFlowFragment(R.layout.fragment_flow_main,R.id.fragment_container_view){
    private val binding by viewBinding(FragmentFlowMainBinding::bind)
    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
        NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}