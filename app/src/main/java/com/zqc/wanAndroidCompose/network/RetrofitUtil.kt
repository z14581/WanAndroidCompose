package com.zqc.wanAndroidCompose.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {

    private val BASE_URL = "https://www.wanandroid.com"

    private val client by lazy {
        println("RetrofitUtil   初始化   OkHttpClient")

        OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()
    }

     val retrofit by lazy {
         println("RetrofitUtil   初始化   retrofit  11")
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}

/**
 * okhttp 日志拦截器
 * @author LTP  2022/3/21
 */
val logInterceptor = HttpLoggingInterceptor { message -> // 使用自己的日志工具接管
    println("RetrofitUtil   请求日志     $message")
}