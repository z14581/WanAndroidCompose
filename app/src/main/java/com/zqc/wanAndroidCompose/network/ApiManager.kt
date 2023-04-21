package com.zqc.wanAndroidCompose.network

import com.btpj.lib_base.data.bean.ApiResponse
import com.btpj.lib_base.data.bean.PageResponse
import com.btpj.wanandroid.data.http.Api
import com.zqc.wanAndroidCompose.data.bean.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ApiManager {

      val service by lazy {
        RetrofitUtil.retrofit.create(Api::class.java)
    }



    suspend fun register(userName:String, passWord:String,repassword:String){

      val response : ApiResponse<Any?> =  withContext(Dispatchers.IO){
            println("  RetrofitUtil      register")
            service.register(userName,passWord,repassword)

        }
        println("  RetrofitUtil      response    $response")

     }


    suspend fun getArticles(){
        val response : ApiResponse<PageResponse<Article>> =  withContext(Dispatchers.IO){
             service.getArticlePageList(0,20)

        }
        println("  RetrofitUtil      response    $response")
    }
}