package com.cba.inewsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cba.core_ui.BaseRecyclerViewAdapter
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.databinding.ItemNewsBinding

class NewsFeedAdapter(
    val newsList : MutableList<NewsItemResult> = ArrayList()
) :BaseRecyclerViewAdapter<ItemNewsBinding,NewsItemResult>() {


    var onNewsItemClick: ((NewsItemResult, Int) -> Unit)? = null

    override fun getView(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemNewsBinding = ItemNewsBinding.inflate(inflater, parent, false)

    override fun bind(binding: ItemNewsBinding, item: NewsItemResult, position: Int) {
        binding.model = item
        binding.root.setOnClickListener {

                onNewsItemClick?.invoke(item, position)

        }
    }
}