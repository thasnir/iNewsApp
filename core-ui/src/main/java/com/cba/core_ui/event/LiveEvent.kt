package com.cba.core_ui.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

class LiveEvent : BaseLiveEvent<String?>() {
    fun postEvent(key:String,value :String){
        super.postValue(Event.create(key,value))
    }
}

open class BaseLiveEvent<Data> : MutableLiveData<Event<Data?>>(){
    fun postEvent(key : String){
        super.postValue(Event.create(key))
    }
    fun observe(owner : LifecycleOwner,onEvent : (EventInfo<Data?>) -> Unit){
        if(hasObservers()){
            removeObservers(owner)
        }
        super.observe(owner){
            val  content=it?.getHandleContent()
            if(content!=null){
                onEvent(content)
            }
        }
    }
}