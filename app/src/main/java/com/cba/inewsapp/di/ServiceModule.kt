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
   fun provideApiBuilder() :ApiBuilder{
      return ApiBuilder.getInstance("https://newsapi.org/v2/",null,null)
   }

   @Provides
   fun provideNewsService(apiBuilder:ApiBuilder):NewsService{
      return apiBuilder.getService(NewsService::class.java)
   }
}