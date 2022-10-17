package com.cba.inewsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cba.core_ui.BaseFragment
import com.cba.inewsapp.databinding.FragmentNewsBinding


class NewsFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel : NewsViewModel by activityViewModels()
    private  var newsFeedAdapter:NewsFeedAdapter? = null
    //val pullToRefresh:

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentNewsBinding.inflate(inflater,container,false)
        binding.viewModel=newsViewModel

        binding.lvNews.layoutManager=LinearLayoutManager(context)
        binding. pullToRefresh.setOnRefreshListener {
            refreshData()
           binding.pullToRefresh.isRefreshing = false
        }
        observeNewsList()
        setHasOptionsMenu(false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setListView(){
     newsFeedAdapter = NewsFeedAdapter()
        binding.lvNews.adapter= newsFeedAdapter
        binding.lvNews.layoutManager=LinearLayoutManager(context)
        newsFeedAdapter?.onNewsItemClick = {_,pos ->
            newsViewModel.selectedItem(pos)
            findNavController().navigate(NewsFragmentDirections.toDetailItem())
        }
        refreshData()
    }
    private  fun refreshData(){
        newsFeedAdapter?.updateItems(newsViewModel.newsList)
    }
    private  fun observeNewsList() {
        observe(newsViewModel.getNewsList()) {
            if (it.success) {
                newsViewModel.listCount.postValue(1)
                setListView()
            }

        }
    }
}