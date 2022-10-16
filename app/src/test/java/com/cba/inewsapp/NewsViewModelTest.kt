package com.cba.inewsapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.content.Context
import com.cba.inewsapp.domain.NewsInteractor
import com.cba.inewsapp.ui.NewsViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule : TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var interactor: NewsInteractor

    private lateinit var  viewModel: NewsViewModel

    @Mock
    @ApplicationContext
    lateinit var  context: Context

}