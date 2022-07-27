package com.example.kmm.presentation
import kotlinx.coroutines.withContext
import com.example.kmm.DI
import com.example.kmm.data.NewsList
import com.example.kmm.threads.ioDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface IView {}

interface INewsListView : IView {
    fun setupNews(data: NewsList)
}

interface INewsListPresenter {
    fun loadNews()
}

class NewsListPresenter : BasePresenter(), INewsListPresenter {
    private val newsService = DI.newsService

    override fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                newsService.loadNews()
            }
            result.getOrNull()?.let {
                (view as? INewsListView)?.setupNews(it)
            }
        }
    }
}