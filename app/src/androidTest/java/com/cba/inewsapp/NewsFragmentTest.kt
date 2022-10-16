package com.cba.inewsapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.cba.inewsapp.ui.NewsFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@HiltAndroidTest
@ExperimentalCoroutinesApi
@LargeTest
@RunWith(AndroidJUnit4ClassRunner :: class)
class NewsFragmentTest {
    lateinit var  fragment: NewsFragment

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltRule.inject()
    }
    @Test
    fun newsListTest(){
        val list=Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.lvNews)
            )
        )
        list.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
         list.perform(click())
    }
    @Test
    fun newsFeedTest(){
        sleep(1000)
        val desc =Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.newHeading)
            )
        )
        desc.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val title =Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.newsTime)
            )
        )
        title.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}