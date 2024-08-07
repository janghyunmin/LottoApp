package dev.kkjang.domain

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val dispatcherDefault: CoroutineDispatcher
    val dispatcherIO: CoroutineDispatcher
    val dispatcherMain: CoroutineDispatcher
}