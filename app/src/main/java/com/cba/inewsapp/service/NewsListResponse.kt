package com.cba.inews.service

import com.google.gson.annotations.SerializedName

class NewsListResponse {
    @SerializedName("response")
    val newsList = ArrayList<NewsItemResponse>()
}
class NewsItemResponse{
    @SerializedName("id")
    var id =0

    @SerializedName("title")
    var title =""

    @SerializedName("description")
    var description =""

    @SerializedName("longDescription")
    var longDescription = ""

    @SerializedName("imageUrl")
    var imageUrl =""
}