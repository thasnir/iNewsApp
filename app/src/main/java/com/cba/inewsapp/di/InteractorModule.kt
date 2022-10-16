package com.cba.inewsapp.di

import com.cba.inewsapp.domain.NewsInteractor
import com.cba.inewsapp.domain.NewsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract  class InteractorModule {
    @Binds
    abstract  fun NewsInteractor(interactor: NewsInteractorImpl):NewsInteractor
}