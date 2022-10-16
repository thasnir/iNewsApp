package com.cba.inewsapp.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelProviderFactory @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel()