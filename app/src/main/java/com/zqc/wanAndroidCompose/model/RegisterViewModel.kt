package com.zqc.wanAndroidCompose.model

import androidx.lifecycle.viewModelScope
import com.zqc.wanAndroidCompose.base.BaseViewModel
import com.zqc.wanAndroidCompose.network.ApiManager
import kotlinx.coroutines.launch

class RegisterViewModel:BaseViewModel() {

    fun register(userName:String,passWord:String,rePassWord:String){
        viewModelScope.launch {
            ApiManager.register(userName,passWord,rePassWord)
        }
    }

}