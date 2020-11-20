package br.com.henriquealtmayer.navigationcomponent.returnresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.henriquealtmayer.navigationcomponent.R
import br.com.henriquealtmayer.navigationcomponent.commons.addBackNavParam
import br.com.henriquealtmayer.navigationcomponent.commons.navBackParamMessage

class ReturnResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_return_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addBackNavParam(navBackParamMessage, "This is the value returned from the back navigation")
    }

}