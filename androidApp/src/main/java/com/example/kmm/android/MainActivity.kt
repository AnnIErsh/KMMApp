package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.Greeting
import android.widget.TextView
import com.example.kmm.presentation.NewsListPresenter

fun greet(): String {
    return Greeting().greeting()
}


class MainActivity : AppCompatActivity() {
    val presenter = NewsListPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadNews()
    }
}
