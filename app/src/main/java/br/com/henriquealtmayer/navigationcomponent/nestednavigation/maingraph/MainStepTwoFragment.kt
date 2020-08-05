package br.com.henriquealtmayer.navigationcomponent.nestednavigation.maingraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_main_step_two.*

class MainStepTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_step_two, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        tv_main_step_two.setOnClickListener {
            findNavController().navigate(MainStepTwoFragmentDirections.goToSimpleNavigationGraph())
        }
    }

}