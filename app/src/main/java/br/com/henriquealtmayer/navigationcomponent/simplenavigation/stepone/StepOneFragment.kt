package br.com.henriquealtmayer.navigationcomponent.simplenavigation.stepone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_step_one.*

class StepOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_step_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        tv_step_one.setOnClickListener {
            findNavController().navigate(StepOneFragmentDirections.goToStepTwo())
        }
    }

}