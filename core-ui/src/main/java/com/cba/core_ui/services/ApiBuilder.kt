package com.cba.core_ui.services

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder {
    private var retrofitBuilder: Retrofit.Builder=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())

    private var httpClientBuilder=OkHttpClient.Builder()
    private lateinit var retrofit: Retrofit

    private fun buildClient(){
        retrofitBuilder.client(httpClientBuilder.build())
        retrofit=retrofitBuilder.build()
    }
    fun <T> getService(clazz: Class<T>) : T {
        return  retrofit.create(clazz)
    }
    companion object {
        private  var INSTANCE:ApiBuilder?=null
        fun getInstance(
          baseUrl : String,
          interceptor: List<Interceptor>?=null,
          authenticator: Authenticator?=null
        ):ApiBuilder{
            if(INSTANCE==null){
                INSTANCE= ApiBuilder()
                INSTANCE?.retrofitBuilder?.baseUrl(baseUrl)
                INSTANCE?.buildClient()
            }
          return INSTANCE!!
        }
    }
}