package com.lambadam.domain

import kotlinx.coroutines.CoroutineDispatcher

interface IDispatcherProvider {

    val io: CoroutineDispatcher

    val default: CoroutineDispatcher

    val ui: CoroutineDispatcher
}