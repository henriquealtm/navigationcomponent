package br.com.henriquealtmayer.navigationcomponent.bottommenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.activity_bottom_menu_navigation.*

class BottomMenuContainerFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_menu_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = requireActivity().findNavController(R.id.fragment)
        val appBarCfg = AppBarConfiguration(
            setOf(
                R.id.BNFirstFragment,
                R.id.BNSecondFragment,
                R.id.BNThirdFragment
            )
        )

        setupActionBarWithNavController(
            requireActivity() as AppCompatActivity,
            navController,
            appBarCfg
        )



        bottomNavigationView.setupWithNavController(requireActivity().findNavController(R.id.fragment))
    }

}