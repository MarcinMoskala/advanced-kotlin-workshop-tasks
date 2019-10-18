package coroutines.ui

import kotlinx.coroutines.*

val UI = newSingleThreadContext("UIThread") // Normally it will be Dispatchers.Main

// TODO: Edit only this class
abstract class BasePresenter(
    private val onError: (Throwable) -> Unit = {}
) {

    fun onDestroy() {}
}