package com.cba.inewsapp.domain

import kotlinx.coroutines.flow.Flow

interface NewsInteractor {
    suspend fun  getLatestNews() : NewsListResult
}