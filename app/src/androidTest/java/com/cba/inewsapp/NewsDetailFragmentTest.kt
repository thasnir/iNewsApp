package com.cba.inewsapp

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@HiltAndroidTest
@ExperimentalCoroutinesApi
@LargeTest
@RunWith(AndroidJUnit4ClassRunner :: class)
class NewsDetailFragmentTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltRule.inject()
        launchFragment<MainActivity>(
            com.cba.inewsapp.R.navigation.navigation_graph,
            R.id.newsFragment
        )
    }

    @Test
    fun newsFeedClickTest() {
        sleep(1000)
        val rvNews = Espresso.onView(ViewMatchers.withId(R.id.lvNews)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        sleep(2000)


       val image = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.appCompatImageView),
                ViewMatchers.isDisplayed()
            )
        )
        image.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val title = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.newsTime),
                ViewMatchers.isDisplayed()
            )
        )
        title.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val desc = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.newHeading),
                ViewMatchers.isDisplayed()
            )
        )
        desc.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val time = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.textView2),
                ViewMatchers.isDisplayed()
            )
        )
        time.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val fav = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.action_fav),
                ViewMatchers.isDisplayed()
            )
        )
        fav.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        fav.perform(click())
        sleep(1000)
        val share = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.action_share),
                ViewMatchers.isDisplayed()
            )
        )
        share.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        share.perform(click())
        sleep(1000)


    }
}