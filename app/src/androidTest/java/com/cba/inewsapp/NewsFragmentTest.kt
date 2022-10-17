package com.cba.inewsapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.cba.inewsapp.domain.NewsItemResult
import com.cba.inewsapp.domain.NewsListResult
import com.cba.inewsapp.ui.NewsFeedAdapter
import com.cba.inewsapp.ui.NewsFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import java.lang.Thread.sleep

@HiltAndroidTest
@ExperimentalCoroutinesApi
@LargeTest
@RunWith(AndroidJUnit4ClassRunner :: class)
class NewsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Mock
    lateinit var newsAdapter : NewsFeedAdapter


    @Before
    fun init(){
        hiltRule.inject()
        launchFragment<MainActivity>(
            com.cba.inewsapp.R.navigation.navigation_graph,
            R.id.newsFragment
        )
    }
    @Test
    fun newsListTest(){
        val list=Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.lvNews),
                ViewMatchers.isDisplayed()
            )
        )
        list.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
         list.perform(click())
    }
    @Test
    fun newsFeedClickTest(){
        sleep(1000)
        val rvNews=Espresso.onView(ViewMatchers.withId(R.id.lvNews)).perform(
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
    }

    @Test
    fun newsAdapterTest(){
        newsAdapter = NewsFeedAdapter()
        val item1= NewsItemResult()
        item1.id=1
        item1.title="Test news"
        item1.imageUrl="Image"
        item1.title="Time"
        item1.shortDescription ="Short desc"
        item1.longDescription="Long desc"

        val item2= NewsItemResult()
        item2.id=2
        item2.title="Test news2"
        item2.imageUrl="Image2"
        item2.title="Time"
        item2.shortDescription ="Short desc"
        item2.longDescription="Long desc"

        val newsList: List<NewsItemResult> = listOf(
            item1,
            item2
        )
        newsAdapter.updateItems(newsList)
        check(newsAdapter.itemCount != 0)
        check(newsAdapter.itemCount == 2)


    }
}