package com.luche.mybillscase.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.luche.mybillscase.R
import com.luche.mybillscase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        configNav()
        configToolbar()
        initInteractions()
    }

    private fun configNav() {
        navHost = supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment
        navController = navHost.navController
    }

    private fun configToolbar() {
        //Configura o frament topLevel
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.entriesListFragment)
        )
        //
        binding.mainToolbar.setupWithNavController(
            navController = navController,
            appBarConfiguration
        )
    }

    private fun initInteractions() {
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            //Verifica se é destino inicial e se NÃO for, define icone de voltar na toolbar
            val isTopLevelDestination =
                appBarConfiguration.topLevelDestinations.contains(destination.id)
            if(!isTopLevelDestination){
                binding.mainToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            }
        }
    }
}