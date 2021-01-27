package br.com.henriquealtmayer.navigationcomponent.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_step_three.*

class StepThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_step_three, container, false)

}