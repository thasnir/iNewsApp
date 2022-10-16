package com.cba.inewsapp.service

import com.cba.inewsapp.utils.URLConstants
import retrofit2.http.GET

interface NewsService {
    @GET(URLConstants.NEWS_URL)
    suspend fun getNews() : NewsListResponse?
}