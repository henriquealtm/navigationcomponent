package br.com.henriquealtmayer.navigationcomponent.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import br.com.henriquealtmayer.navigationcomponent.commons.*
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

        initializeButtonOnClick(btn_return_result, dir.goToReturnResultFrag())

        initializeButtonOnClick(btn_dynamic_feature_graph, dir.goToDynamicFeatureFrag())

        initializeDeepLinkButton()

        initializeReturnParamObserving()
    }

    private fun initializeButtonOnClick(
        button: Button,
        navDirections: NavDirections
    ) {
        button.setOnClickListener {
            findNavController().navigate(navDirections)
        }
    }

    private fun initializeDeepLinkButton() {
        btn_deep_link.setOnClickListener {
            showNotification(
                title = "Deep Link",
                text = "Open deep link in simple graph (third screen)",
                smallIcon = R.drawable.ic_launcher_background,
                destinationGraphId = R.id.stepThreeFragment
            )
        }
    }

    private fun initializeReturnParamObserving() {
        observeBackNavParam<String>(navBackParamMessage) { message ->
            if (isVisible) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                removeBackNavParam<String>(navBackParamMessage)
            }
        }
    }

}