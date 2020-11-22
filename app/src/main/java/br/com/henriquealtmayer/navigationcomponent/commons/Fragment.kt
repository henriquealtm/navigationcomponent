package br.com.henriquealtmayer.navigationcomponent.commons

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
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

fun <T> Fragment.removeBackNavParam(
    paramTag: String
) {
    findNavController()
        .currentBackStackEntry
        ?.savedStateHandle
        ?.remove<T>(paramTag)
}

// Notification - Section
fun Fragment.showNotification(
    title: String,
    text: String,
    @DrawableRes smallIcon: Int,
    @IdRes destinationGraphId: Int? = null,
    channelId: String = defaultNotificationChannelId
) {
    requireContext().initializeNotificationChannel(channelId = channelId)

    val builder = NotificationCompat.Builder(requireContext(), channelId)
        .setContentTitle(title)
        .setSmallIcon(smallIcon)

    val pendingIntent = destinationGraphId?.let {
        findNavController()
            .createDeepLink()
            .setDestination(destinationGraphId)
            .createPendingIntent()
    }

    val notification = builder.setContentText(text)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .apply {
            pendingIntent?.let { intent ->
                setContentIntent(intent)
            }
        }
        .build()

    NotificationManagerCompat.from(requireContext()).apply {
        cancelAll()
        notify(id, notification)
    }
}