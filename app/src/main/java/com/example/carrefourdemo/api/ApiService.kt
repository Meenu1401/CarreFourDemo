package github.com.githubuser.api

import com.example.carrefourdemo.model.Repo
import com.example.carrefourdemo.model.ServerResonse
import com.example.carrefourdemo.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("/users/{username}")
    fun getUser(
        @Path("username") username: String
    ): Call<User>


    @GET("/users/{username}/repos")
    fun getRepoes(
        @Path("username") username: String
    ): Call<List<Repo>>


}