package com.cba.inewsapp.di

import com.cba.core_ui.services.ApiBuilder
import com.cba.inewsapp.service.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

   @Provides
   fun provideNewsService(apiBuilder:ApiBuilder):NewsService{
      return apiBuilder.getService(NewsService::class.java)
   }
}