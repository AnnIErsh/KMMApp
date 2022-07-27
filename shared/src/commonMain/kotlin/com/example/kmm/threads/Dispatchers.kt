package com.example.kmm.threads

import kotlinx.coroutines.CoroutineDispatcher

expect val ioDispatcher: CoroutineDispatcher
expect val uiDispatcher: CoroutineDispatcher