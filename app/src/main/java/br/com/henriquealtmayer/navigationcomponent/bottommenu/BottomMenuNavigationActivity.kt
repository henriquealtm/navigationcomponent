package br.com.henriquealtmayer.navigationcomponent.bottommenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.activity_bottom_menu_navigation.*

class BottomMenuNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_menu_navigation)

        val navController = findNavController(R.id.fragment)
        val appBarCfg = AppBarConfiguration(
            setOf(
                R.id.BNFirstFragment,
                R.id.BNSecondFragment,
                R.id.BNThirdFragment
            )
        )

        setupActionBarWithNavController(navController, appBarCfg)

        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {

        findNavController(R.id.fragment).navigateUp()

        return super.onSupportNavigateUp()
    }

}