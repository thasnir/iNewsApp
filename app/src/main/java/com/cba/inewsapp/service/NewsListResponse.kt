package com.cba.inewsapp.service

import com.google.gson.annotations.SerializedName

class NewsListResponse {
    @SerializedName("articles")
    val newsList = ArrayList<NewsItemResponse>()
}
class NewsItemResponse{


    @SerializedName("title")
    var title =""

    @SerializedName("description")
    var description =""

    @SerializedName("content")
    var longDescription = ""

    @SerializedName("url")
    var url = ""

    @SerializedName("publishedAt")
    var time =""

    @SerializedName("urlToImage")
    var imageUrl =""
}