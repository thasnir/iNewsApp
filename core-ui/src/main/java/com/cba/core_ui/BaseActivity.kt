package com.cba.core_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class BaseActivity : AppCompatActivity() {

   // @Inject
   // lateinit var mViewModelFactory: ViewModelProvider.Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }
 /*   protected inline  fun <reified  T:BaseViewModel> getViewModel(): T{

        return ViewModelProvider(this,mViewModelFactory).get(T::class.java)
    }*/

}