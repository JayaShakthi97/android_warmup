package com.example.warmupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view_with_cards.*

class RecyclerViewWithCards : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_cards)

        val articleList: ArrayList<Article> = Article.createList(20);

        viewManager = LinearLayoutManager(this)
        viewAdapter = ArticleAdapter(articleList)

        rv_articles.layoutManager = viewManager
        rv_articles.adapter = viewAdapter
    }
}