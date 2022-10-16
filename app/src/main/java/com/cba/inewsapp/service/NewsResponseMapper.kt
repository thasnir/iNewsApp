package com.cba.inewsapp.service

import android.content.Context
import android.util.Log
import com.cba.core_domain.Mapper
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.domain.NewsListResult

class NewsResponseMapper(val context: Context):
  Mapper<NewsListResponse?, NewsListResult>{
  override fun convert(request: NewsListResponse?): NewsListResult {
    val newsListResult = NewsListResult()
    request?.newsList?.forEach{
      val newsItemResult = NewsItemResult()

      newsItemResult.title=it.title

      newsItemResult.shortDescription=it.description
      newsItemResult.longDescription=it.longDescription
      newsItemResult.imageUrl=it.imageUrl
      newsItemResult.time=it.time
      newsListResult.newsList?.add(newsItemResult)
    }

    return newsListResult
  }
}