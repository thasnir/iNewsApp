package com.cba.inewsapp.domain

import com.cba.core_domain.BaseResult


class NewsListResult : BaseResult(){
    var newsList =ArrayList<NewsItemResult>()
}
class NewsItemResult  {
    var id: Int?=0
    var title : String?=null
    var imageUrl : String ?=null
    var shortDescription : String?=null
    var longDescription : String?=null
}