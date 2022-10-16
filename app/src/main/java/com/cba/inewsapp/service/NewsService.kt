package com.cba.inewsapp.service

import com.cba.inews.service.NewsListResponse
import com.cba.inewsapp.utils.URLConstants
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {
    @GET(URLConstants.NEWS_URL)
    suspend fun getNews() : NewsListResponse?
}