package com.cba.inewsapp.service

import android.content.Context
import com.cba.core_domain.Mapper
import com.cba.inews.service.NewsListResponse
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.domain.NewsListResult

class NewsResponseMapper(val context: Context):
  Mapper<NewsListResponse?, NewsListResult>{
  override fun convert(request: NewsListResponse?): NewsListResult {
    val newsListResult = NewsListResult()
    request?.newsList?.forEach{
      val newsItemResult = NewsItemResult()
      newsItemResult.id= it.id
      newsItemResult.title=it.title
      newsItemResult.shortDescription=it.description
      newsItemResult.longDescription=it.longDescription
      newsItemResult.imageUrl=it.imageUrl
      newsListResult.newsList?.add(newsItemResult)
    }

    return newsListResult
  }
}