package com.example.carrefourdemo.interactor

import com.example.carrefourdemo.api.RetrofitClient
import com.example.carrefourdemo.model.ServerResonse
import com.example.carrefourdemo.model.User
import github.com.githubuser.api.ApiService
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserInteractor {


    fun getUser(username: String): Observable<ServerResonse<User>> {

        return Observable.create {
            val observable = RetrofitClient.getRetrofitInstance().create(ApiService::class.java)
            val call = observable.getUser(username)

            call.enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable?) {
                    it.onNext(ServerResonse(false, null, null, 0))
                }

                override fun onResponse(
                    call: Call<User>?,
                    response: Response<User>?
                ) {
                    it.onNext(ServerResonse(true, response?.body(), null, 0))
                }
            })
        }
    }
}




