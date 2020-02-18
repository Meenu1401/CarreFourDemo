package com.example.carrefourdemo.interactor

import com.example.carrefourdemo.api.RetrofitClient
import com.example.carrefourdemo.model.Repo
import com.example.carrefourdemo.model.ServerResonse
import com.example.carrefourdemo.model.User
import github.com.githubuser.api.ApiService
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectListInteractor {


    fun getRepoList(username: String): Observable<ServerResonse<List<Repo>>> {

        return Observable.create {
            val observable = RetrofitClient.getRetrofitInstance().create(ApiService::class.java)
            val call = observable.getRepoes(username)

            call.enqueue(object : Callback<List<Repo>> {
                override fun onFailure(call: Call<List<Repo>>, t: Throwable?) {
                    it.onNext(ServerResonse(false, null, null, 0))
                }

                override fun onResponse(
                    call: Call<List<Repo>>?,
                    response: Response<List<Repo>>?
                ) {
                    it.onNext(ServerResonse(true, response?.body(), null, 0))
                }
            })
        }
    }
}