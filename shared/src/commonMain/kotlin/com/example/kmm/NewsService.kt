package com.example.kmm

import com.example.kmm.data.NewsList
import com.example.kmm.network.NetworkClient

class NewsService constructor(private val networkClient: NetworkClient) {

    suspend fun loadNews():Result<NewsList> {
        val data = networkClient.getData<NewsList>(LOAD_CRUNCH)
        print(data)
        return data
    }

    companion object {
        private const val api = "a59e5f24831a4322b535578654582973"
        private const val LOAD_CRUNCH = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=${api}"
    }
}

// val api = "a59e5f24831a4322b535578654582973"