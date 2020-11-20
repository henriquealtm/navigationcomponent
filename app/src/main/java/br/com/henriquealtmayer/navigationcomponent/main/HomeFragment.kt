package br.com.henriquealtmayer.navigationcomponent.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import br.com.henriquealtmayer.navigationcomponent.commons.showActionBar
import kotlinx.android.synthetic.main.fragment_home.*

private typealias dir = HomeFragmentDirections

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        showActionBar()

        initializeButtonOnClick(btn_simple_navigation, dir.goToSimpleGraph())

        initializeButtonOnClick(btn_nested_navigation, dir.goToNestedGraph())

        initializeButtonOnClick(btn_bottom_menu, dir.goToBottomMenuContainerFrag())

        initializeButtonOnClick(btn_custom_back, dir.goToCustomBackFrag())

        initializeButtonOnClick(btn_return_result, dir.goToCustomBackFrag())
    }

    private fun initializeButtonOnClick(
        button: Button,
        navDirections: NavDirections
    ) {
        button.setOnClickListener {
            findNavController().navigate(navDirections)
        }
    }

}