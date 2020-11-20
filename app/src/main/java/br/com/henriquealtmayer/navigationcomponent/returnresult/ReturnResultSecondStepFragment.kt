package br.com.henriquealtmayer.navigationcomponent.returnresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.henriquealtmayer.navigationcomponent.R

class ReturnResultSecondStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_return_result_second_step, container, false)


}