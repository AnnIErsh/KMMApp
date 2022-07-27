package com.example.kmm

import com.example.kmm.network.NetworkClient
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object DI {
    val networkClient: NetworkClient by lazy {
        NetworkClient()
    }

    val newsService: NewsService by lazy {
        NewsService(networkClient)
    }
}