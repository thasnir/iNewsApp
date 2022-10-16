package com.cba.inewsapp.di

import com.cba.inewsapp.MainActivity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent :: class)
abstract class ActivityModule {
    @ActivityScoped
    @Binds
    abstract fun mainActivity(mainActivity: MainActivity) : MainActivity
}