package com.cba.core_ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.cba.core_domain.BaseResult
import com.cba.core_ui.event.CoreEvents
import com.cba.core_ui.event.LiveEvent

open class BaseFragment : Fragment() {


    protected fun  <T: BaseResult> observe(
        liveData: LiveData<T>,
        onData : (T) -> Unit
    ){
        observe(liveData = liveData,onData=onData, handleBaseError = true)
    }
    protected  fun <T: BaseResult> observe(
        liveData: LiveData<T>,
        onData : (T) -> Unit,
        handleBaseError: Boolean=true
    ){
        observeInternal(
            liveData = liveData,
            onData=onData,
            {code,msg -> onBaseEvents(code,msg) },
            handleBaseError=handleBaseError
        )
    }

protected fun observe(
liveEvent: LiveEvent,
onSuccess: () -> Unit,
handleBaseError : Boolean =true,
onFailure : ((errorCode :String) -> Unit)? = null
) {
    observeInternal(
        liveEvent = liveEvent,
        onSuccess = onSuccess,
        handleBaseError = handleBaseError,
        onFailure = onFailure,
        onBaseEvents = { onBaseEvents(it) }
    )
}
    open fun onBaseEvents(
       errorCode: String?,
       message :String = "Something went wrong"
    ) {
    }
}



    fun LifecycleOwner.observeInternal(
        liveEvent: LiveEvent,
        onSuccess: () -> Unit,
        handleBaseError: Boolean =true,
        onFailure: ((errorCode: String) -> Unit)? = null,
        onBaseEvents: (key:String) -> Unit
    ) {

        liveEvent.observe(this) {
            when(it.key){
                CoreEvents.SUCCESS -> onSuccess()
                else ->{
                    onFailure?.invoke(it.key)
                    if(handleBaseError) onBaseEvents(it.key)
                }
            }

        }
    }

    fun <T : BaseResult> LifecycleOwner.observeInternal(
        liveData: LiveData<T>,
        onData : (T) -> Unit,
        onBaseEvents : (errorCode : String? , errorMsg : String) -> Unit,
        handleBaseError: Boolean=true
    ) {
        liveData.observe(this) {
            onData(it)
            if (handleBaseError) {
                onBaseEvents(it.errorResult?.errorCode, it.errorResult?.errorMsg ?: "")
            }
        }
    }

