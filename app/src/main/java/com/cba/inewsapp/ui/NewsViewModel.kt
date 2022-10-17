package com.cba.inewsapp.ui

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cba.core_ui.BaseViewModel
import com.cba.inewsapp.di.IoCoroutine
import com.cba.inewsapp.domain.NewsInteractor
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.domain.NewsListResult
import com.cba.inewsapp.domain.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
   private val newsInteractor : NewsInteractor,
    @IoCoroutine private val defaultDispatcher: CoroutineDispatcher
) : BaseViewModel() {

    var newsList =ArrayList<NewsItemResult>()
    var item=NewsItemResult()
    var listCount = MutableLiveData<Int>(0)

    @SuppressLint("SuspiciousIndentation")
    @JvmName("getNewsList1")
    fun getNewsList() : LiveData<NewsListResult> {
        val liveData =MutableLiveData<NewsListResult>()
        launch(defaultDispatcher){
            newsList.clear()
          val list=  newsInteractor.getLatestNews()
            list.newsList?.let{
                newsList.addAll(it)
            }
          liveData.postValue(list)
        }
        return liveData
    }

    fun selectedItem(pos: Int) {
      item =newsList.get(pos)
    }
}