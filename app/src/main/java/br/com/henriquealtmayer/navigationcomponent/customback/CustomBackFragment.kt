package br.com.henriquealtmayer.navigationcomponent.customback

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import br.com.henriquealtmayer.navigationcomponent.R

class CustomBackFragment : Fragment() {

    private val DIALOG_TAG = "dialogTag"

    private lateinit var backPressedCallback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_custom_back, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeOnBackPressedCallback()
    }

    private fun initializeOnBackPressedCallback() {
        backPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showDialog()
            }
        }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, backPressedCallback)
    }

    private fun showDialog() {
        context?.let { ctx ->
            AlertDialog.Builder(ctx)
                .setTitle("Tem certeza que deseja sair?")
                .setNegativeButton("Não") { _, _ -> }
                .setPositiveButton("Sim") { dialog, which ->
                    backPressedCallback.isEnabled = false

                    activity?.onBackPressedDispatcher?.onBackPressed()
                }
                .show()
        }
    }

}