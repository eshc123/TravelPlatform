package com.eshc.travelplatform.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.set
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation(true)

    }
    fun initNavigation(bool : Boolean){
        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        //보류
//        val inflater = navHostFragment.navController.navInflater
//        val navGraph : NavGraph = inflater.inflate(R.navigation.plan)
//        val destination = if(bool) R.id.navigation_plan else R.id.navigation_plan
//        navGraph.setStartDestination(destination)

        //navController.setGraph(navGraph,null)
        // Passing each menu ID as a set of Ids because each
        // menu should be consider  ed as top level destinations.
        navView.setupWithNavController(navController)
    }
}