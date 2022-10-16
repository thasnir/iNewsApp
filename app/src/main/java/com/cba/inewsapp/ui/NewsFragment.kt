package com.cba.inewsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.cba.inewsapp.databinding.FragmentNewsBinding
import com.cba.inewsapp.ui.NewsViewModel


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel : NewsViewModel by activityViewModels()
    private  var newsFeedAdapter:NewsFeedAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
       // newsViewModel.getNewsList()
      //  binding.viewModel = newsViewModel
        setListView()
    }
    private fun setListView(){
   newsFeedAdapter = NewsFeedAdapter()
        binding.lvNews.adapter= newsFeedAdapter
        newsFeedAdapter?.updateItems(newsViewModel.newsList)
        newsFeedAdapter?.onNewsItemClick = {_,_ ->

        }
    }
    private  fun observeNewsList(){

    }
}