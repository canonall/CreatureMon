package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.ActivityMainBinding
import com.canonal.creaturemon.di.AppModule
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val creatureViewModel: CreatureViewModel by viewModels {
        CreatureViewModelFactory(AppModule.getCreatureRepository(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.creature_nav_host_fragment) as NavHostFragment?
                ?: return

        val navController = host.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.creatureListFragment)
        )
        setToolBar()
        setupActionBar(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.creatureListFragment) {
            creatureViewModel.deleteAllCreatures()
            item.onNavDestinationSelected(findNavController(R.id.creature_nav_host_fragment))
        } else {
            item.onNavDestinationSelected(findNavController(R.id.creature_nav_host_fragment))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.creature_nav_host_fragment).navigateUp(
            appBarConfiguration
        )
    }

    private fun setToolBar() {
        setSupportActionBar(activityMainBinding.toolbar)
    }

    private fun setupActionBar(
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}