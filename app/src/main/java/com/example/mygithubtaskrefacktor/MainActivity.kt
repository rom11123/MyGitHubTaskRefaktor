package com.example.mygithubtaskrefacktor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mygithubtaskrefacktor.databinding.ActivityMainBinding
import com.example.mygithubtaskrefacktor.starter.StarterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<StarterViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_MyGithubTaskRefacktor)
        setContentView(binding.root)


//        val navController = findNavController(R.id.fragmentContainerView)
        start()
    }


    fun start(){
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavigation.setupWithNavController(navController)

        viewModel.checkIsAuthenticated()
        viewModel.isAuthenticated.observe(this) {

            navController.graph = navController.navInflater.inflate(R.navigation.nav_graph).apply {
                setStartDestination(
                    if (it) {
                        R.id.repositoryFragment
                    } else {
                        R.id.loginFragment
                    }
                )
            }
            if (it) {
                navController.navigate(R.id.action_global_repositoryFragment)
            } else {
                navController.navigate(R.id.action_global_loginFragment)
            }
        }
    }
    }
