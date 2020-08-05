package br.com.henriquealtmayer.navigationcomponent.nestednavigation.maingraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_main_step_one.*
import kotlinx.android.synthetic.main.fragment_main_step_two.*
import kotlinx.android.synthetic.main.fragment_step_one.*

class MainStepOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_step_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        tv_main_step_one.setOnClickListener {
            findNavController().navigate(MainStepOneFragmentDirections.goToStepTwo())
        }
    }

}