package br.com.henriquealtmayer.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_b_n_second.*

class BNSecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_b_n_second, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        tv_b_n_first_go_to_nested_graph.setOnClickListener {
            findNavController().navigate(BNSecondFragmentDirections.goToNestedNavigationGraph())
        }
    }

}