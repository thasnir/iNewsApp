package com.cba.inewsapp.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.SOURCE)
@Qualifier
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION
)
annotation class MainCoroutine()
