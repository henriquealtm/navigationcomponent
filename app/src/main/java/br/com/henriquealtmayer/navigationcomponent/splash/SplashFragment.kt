package br.com.henriquealtmayer.navigationcomponent.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R
import br.com.henriquealtmayer.navigationcomponent.commons.hideActionBar

class SplashFragment : Fragment() {

    private val splashDelay = 1000L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideActionBar()

        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.goToHomeFragment())
        }, splashDelay)
    }

}