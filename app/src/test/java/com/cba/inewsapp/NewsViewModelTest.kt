package com.cba.inewsapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.content.Context
import com.cba.inewsapp.domain.NewsInteractor
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.domain.NewsListResult
import com.cba.inewsapp.ui.NewsViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
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

    private lateinit var newsResult: NewsListResult

    @Mock
    @ApplicationContext
    lateinit var  context: Context

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        viewModel= NewsViewModel(interactor,testCoroutineRule.testCoroutineDispatcher)
        newsResult = NewsListResult()
    }

    @Test
    fun get_new_verify_interactor(){
        testCoroutineRule.runBlockingTest {
            Mockito.doReturn(newsResult).`when`(interactor).getLatestNews()
            viewModel.getNewsList()
            Mockito.verify(interactor).getLatestNews()

        }
    }

    @Test
    fun get_new_list_not_null(){
        testCoroutineRule.runBlockingTest {
            Mockito.doReturn(newsResult).`when`(interactor).getLatestNews()
            val liveData=viewModel.getNewsList()
            viewModel.newsList.let {
                assert(it.isNotEmpty())
            }
            Assert.assertNotNull(liveData)
        }
    }

    @Test
    fun get_new_list_result_success(){
        testCoroutineRule.runBlockingTest {
            val newsResult= NewsListResult()
            newsResult.success=true
            Mockito.doReturn(newsResult).`when`(interactor).getLatestNews()
            val result=viewModel.getNewsList()
            result.value?.success?.let { assert(it) }
        }
    }

    @Test
    fun get_new_list_result_fail(){
        testCoroutineRule.runBlockingTest {
            val newsResult= NewsListResult()
            newsResult.success=false
            Mockito.doReturn(newsResult).`when`(interactor).getLatestNews()
            val result=viewModel.getNewsList()
            result.value?.success?.let { assert(!it) }
        }
    }

    @Test
    fun get_new_list_result_not_empty(){
        testCoroutineRule.runBlockingTest {
            val newsResult= NewsListResult()
            newsResult.success=true
            newsResult.newsList= arrayListOf(NewsItemResult())
            Mockito.doReturn(newsResult).`when`(interactor).getLatestNews()
            val result=viewModel.getNewsList()
            result.value?.newsList?.isNotEmpty()?.let { assert(it) }
        }
    }

}