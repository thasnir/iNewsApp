package com.cba.core_ui.event

class Event<Data>(private val content : EventInfo<Data?>) {

    var hasBeenHandled=false
    private set

    fun getHandleContent() : EventInfo<Data?>?{
        return  if(hasBeenHandled) null else{
            hasBeenHandled=true
            content
        }
    }
   companion object{
        fun <Data> create(key : String, data : Data? = null) : Event<Data>{
            val content : EventInfo<Data?> = EventInfo(key,data)
            return Event(content  )
        }
    }
}

//Data class holding navigation event info
data class EventInfo<T>(val key : String, val data : T?=null)