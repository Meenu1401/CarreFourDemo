package com.example.carrefourdemo.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



object RetrofitClient {

    const val BASE_URL = "https://api.github.com/"
    private var responsCode: Int? = null


    //client
    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor {

            val request = it.request()
            val response = it.proceed(request)

            responsCode = response.code()



            return@addInterceptor response
        }
        .build()



//    inline fun <reified T> createWebAPI(): T {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create(T::class.java)
//    }


     fun getRetrofitInstance(): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

}