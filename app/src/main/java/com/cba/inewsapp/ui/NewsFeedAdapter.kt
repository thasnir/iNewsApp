package com.cba.inewsapp.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.databinding.ItemNewsBinding

class NewsFeedAdapter(
    initialList : List<NewsItemResult>,
    private val onClickListener : (NewsItemResult) -> Unit
) :RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    init {

    }
    inner class NewsFeedVh(private val binding: ItemNewsBinding):
                      RecyclerView.ViewHolder(binding.root){
           fun binding(item : NewsItemResult)  {
              // binding.model = item
           }
  }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}