package com.cba.core_ui.event

import androidx.lifecycle.MutableLiveData

class LiveEvent : BaseLiveEvent<String?>() {
}

open class BaseLiveEvent<Data> : MutableLiveData<Event<Data?>>(){
    fun postEvent(key : String){
       // super.postValue(Event.c)
    }
}