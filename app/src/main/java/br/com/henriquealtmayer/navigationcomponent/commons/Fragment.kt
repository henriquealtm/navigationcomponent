package br.com.henriquealtmayer.navigationcomponent.commons

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.hideActionBar() {
    when (activity) {
        is AppCompatActivity -> (activity as? AppCompatActivity)?.supportActionBar?.hide()
        else -> activity?.actionBar?.hide()
    }
}

fun Fragment.showActionBar() {
    when (activity) {
        is AppCompatActivity -> (activity as? AppCompatActivity)?.supportActionBar?.show()
        else -> activity?.actionBar?.show()
    }
}