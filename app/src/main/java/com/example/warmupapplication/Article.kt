package com.example.warmupapplication

class Article(val title: String, val subTitle: String, val content: String) {
    companion object {
        private var lastId = 0

        fun createList(count: Int): ArrayList<Article> {
            val articles = ArrayList<Article>()
            for (i in 1..count) {
                articles.add(
                    Article(
                        "Article " + ++lastId,
                        "This is subtitle",
                        "This is the content. This is the content. " +
                                "This is the content. This is the content. This is the content."
                    )
                )
            }

            return articles
        }
    }
}