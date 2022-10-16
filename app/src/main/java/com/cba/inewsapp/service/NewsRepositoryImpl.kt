package com.cba.inewsapp.service

import android.content.Context
import com.cba.inewsapp.domain.NewsListResult
import com.cba.inewsapp.domain.NewsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
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
           // newsResult.p
        }

        return newsResult
    }
}