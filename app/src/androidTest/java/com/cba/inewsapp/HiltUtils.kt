package com.cba.inewsapp

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavDeepLinkBuilder
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry

inline  fun <reified  A : AppCompatActivity> launchFragment(
    @NavigationRes navigationResource : Int,
    @IdRes fragmentId : Int,
    fragmentArgs: Bundle?=null
){
    launchFragmentWithDeeplink<A>(fragmentArgs,null,navigationResource,fragmentId)
}

inline fun <reified  A : AppCompatActivity> launchFragmentWithDeeplink(
    fragmentArgs: Bundle?=null,
    fragmentFactory: FragmentFactory?=null,
    @NavigationRes navigationResource: Int,
    @IdRes fragmentId: Int) {
    val launchIntent =
        NavDeepLinkBuilder(InstrumentationRegistry.getInstrumentation().targetContext)
            .setGraph(navigationResource)
            .setComponentName(A::class.java)
            .setDestination(fragmentId)
            .setArguments(fragmentArgs)
            .createTaskStackBuilder().intents[0]
    ActivityScenario.launch<A>(launchIntent).onActivity { activity ->
        fragmentFactory?.let {
            activity.supportFragmentManager.fragmentFactory = it
        }

    }
}
