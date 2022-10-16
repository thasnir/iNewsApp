package com.cba.inewsapp.domain

import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(val repository : NewsRepository) : NewsInteractor {
    override suspend fun getLatestNews(): NewsListResult {
        //  return flow {
        // val cached =repository.getCachedLatestNews()
        /* if(!cached.newsList.isNullOrEmpty()){
                cached.Success=true
                emit(cached)
            }*/
        return repository.getLatestNews()

        // }
    }
}