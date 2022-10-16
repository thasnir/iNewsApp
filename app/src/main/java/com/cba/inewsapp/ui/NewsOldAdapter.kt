package com.cba.inewsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cba.inewsapp.databinding.ItemNewsBinding
import com.cba.inewsapp.domain.NewsItemResult

class NewsOldAdapter (
    private val largeNewsList: List<NewsItemResult>
) : RecyclerView.Adapter<LargeNewsViewHolder>() {

    private lateinit var binding: ItemNewsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeNewsViewHolder {
        binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LargeNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LargeNewsViewHolder, position: Int) {
        val largeNews = largeNewsList[position]
        holder.bind(largeNews)
    }

    override fun getItemCount(): Int = largeNewsList.size

}
class LargeNewsViewHolder(
    private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(largeNews: NewsItemResult) {
        binding.model = largeNews
    }
}