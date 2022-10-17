package com.cba.inewsapp.service

import android.content.Context
import android.util.Log
import android.util.Log.WARN
import com.cba.inewsapp.domain.NewsListResult
import com.cba.inewsapp.domain.NewsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.internal.platform.Platform.WARN
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private  val newsService: NewsService,
    @ApplicationContext val context: Context

) : NewsRepository {
    override suspend fun getLatestNews(): NewsListResult {
        var newsResult = NewsListResult()
        try{
            val data = newsService.getNews()
            newsResult= NewsResponseMapper(context).convert(data)
            newsResult.success=true
        }catch (throwable : Throwable){
        }
        return newsResult
    }
}