package com.cba.inewsapp.ui

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cba.inewsapp.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel : NewsViewModel by activityViewModels()
    private  var newsFeedAdapter:NewsFeedAdapter? = null
    //val pullToRefresh: SwipeRefreshLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentNewsBinding.inflate(inflater,container,false)
        binding.viewModel=newsViewModel
       // val pullToRefresh: SwipeRefreshLayout = findViewById(R.id.pullToRefresh)
        newsViewModel.getNewsList()
       binding. pullToRefresh.setOnRefreshListener {
            refreshData() // your code
           binding.pullToRefresh.isRefreshing = false
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){

        setListView()
      //  binding.viewModel = newsViewModel
       // setListView()
     /*   val newsAdapter = NewsOldAdapter(newsViewModel.newsList)

        binding.lvNews.adapter = newsAdapter
        binding.lvNews.layoutManager = LinearLayoutManager(context)
        binding.lvNews.setHasFixedSize(true)*/
    }
    @SuppressLint("SuspiciousIndentation")
    private fun setListView(){
     newsFeedAdapter = NewsFeedAdapter()
        binding.lvNews.adapter= newsFeedAdapter
        newsFeedAdapter?.onNewsItemClick = {_,_ ->

        }
        refreshData()
    }
    private  fun refreshData(){
        newsFeedAdapter?.updateItems(newsViewModel.newsList)
    }
}