package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.data.NewsItem
import android.widget.TextView
import com.example.kmm.presentation.NewsListPresenter
import com.example.kmm.presentation.INewsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.kmm.data.NewsList
import com.example.kmm.presentation.INewsListPresenter

class MainActivity : AppCompatActivity(), INewsListView {
    private val presenter: INewsListPresenter by lazy {
        val presenter = NewsListPresenter()
        presenter.attachView(this)
        presenter
    }
    var mListView: ListView? = null
    lateinit var arrayAdapter: ArrayAdapter<*>
    var items: ArrayList<NewsItem> = arrayListOf()
    var titles: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListView = findViewById<ListView>(R.id.articleList)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadNews()
    }

    override fun setupNews(data: NewsList) {
        items.addAll(data.articles)
        for (item in items) {
            val str: String? = item.title
            if (str != null) {
                titles.add(str)
            }
        }
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, titles)
        arrayAdapter.notifyDataSetChanged();
        mListView?.adapter = arrayAdapter
    }
}
