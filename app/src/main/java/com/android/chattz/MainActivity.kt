package com.android.chattz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.android.chattz.app.App
import com.android.chattz.utils.TOKEN
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupNavigation()
    }

    private fun setupNavigation() {
        val validation = App.sharedPreferences.getString(TOKEN,null)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController

        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_base_graph).apply {
            setStartDestination(
                if (validation.isNullOrEmpty())
                    R.id.nav_auth
                else
                    R.id.nav_main
            )
        }
        navController.graph = graph
        NavigationUI.setupWithNavController(findViewById(R.id.toolbar), navController, null)
    }
}