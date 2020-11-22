package br.com.henriquealtmayer.navigationcomponent.commons

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.henriquealtmayer.navigationcomponent.R

// Action Bar - Section
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

// Back Navigation Param - Section
fun <T> Fragment.addBackNavParam(
    paramTag: String,
    value: T
) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(
        paramTag,
        value
    )
}

fun <T> Fragment.observeBackNavParam(
    paramTag: String,
    onChange: (T) -> Unit
) {
    findNavController()
        .currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<T>(paramTag)
        ?.observe(viewLifecycleOwner, Observer { value ->
            onChange.invoke(value)
        })
}

// Notification - Section
fun Fragment.showNotification() {
    context?.initializeNotificationChannel()

    val builder = NotificationCompat.Builder(requireContext(), "123")
    builder.setContentTitle("Titulo do push")
        .setSmallIcon(R.drawable.ic_first)
    val text = "Texto"
    val notification = builder.setContentText(text)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .build()
    val notificationManager =
        NotificationManagerCompat.from(requireContext())
    notificationManager.cancelAll()
    notificationManager.notify(id, notification)
}