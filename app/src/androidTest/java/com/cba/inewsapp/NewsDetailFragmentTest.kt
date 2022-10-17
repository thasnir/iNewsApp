package com.cba.inewsapp

import androidx.core.widget.NestedScrollView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
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
            R.id.newsDetailFragment
        )
    }

    @Test
    fun newsDetailsTest(){
        val scrollView= Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.scrollView),
                ViewMatchers.withParent(ViewMatchers.withParent(IsInstanceOf.instanceOf(NestedScrollView::class.java))),
                ViewMatchers.isDisplayed()
            )
        )
        scrollView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
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


    }
}