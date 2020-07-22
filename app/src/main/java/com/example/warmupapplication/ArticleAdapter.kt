package com.example.warmupapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article_card_item.view.*

class ArticleAdapter(private val dataSet: ArrayList<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(val article: View) : RecyclerView.ViewHolder(article) {
        val articleCard: CardView = article.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ArticleViewHolder {
        val articleView = LayoutInflater.from(parent.context).inflate(
            R.layout.article_card_item, parent, false
        )

        return ArticleViewHolder(articleView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article: Article = dataSet[position]
        val articleView = holder.articleCard
        articleView.title_text.text = article.title
        articleView.sub_title_text.text = article.subTitle
        articleView.content_text.text = article.content
    }

    override fun getItemCount() = dataSet.size
}