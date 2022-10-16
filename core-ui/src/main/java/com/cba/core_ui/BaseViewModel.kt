package com.cba.core_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

open class BaseViewModel :ViewModel() {

    protected  fun launch(defaultDispatcher : CoroutineDispatcher,action: suspend () -> Unit){
        viewModelScope.launch(defaultDispatcher) {
            action.invoke()
        }
    }

}