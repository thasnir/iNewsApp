package com.cba.inewsapp.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.SOURCE)
@Qualifier
@kotlin.annotation.Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION
)
annotation class IoCoroutine
