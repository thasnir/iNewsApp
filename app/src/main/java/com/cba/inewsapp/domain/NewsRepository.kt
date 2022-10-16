package com.cba.inewsapp.domain

import com.cba.inewsapp.domain.NewsListResult

interface NewsRepository {
    suspend fun  getLatestNews() : NewsListResult
}