package com.cba.inewsapp.domain

import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(val repository : NewsRepository) : NewsInteractor {
    override suspend fun getLatestNews(): NewsListResult {
        return repository.getLatestNews()
    }
}