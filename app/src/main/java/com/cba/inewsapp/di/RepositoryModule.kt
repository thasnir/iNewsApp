package com.cba.inewsapp.di

import com.cba.inewsapp.domain.NewsRepository
import com.cba.inewsapp.service.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
     @Binds
     abstract fun provideNewsRepository(repository :NewsRepositoryImpl):NewsRepository
}