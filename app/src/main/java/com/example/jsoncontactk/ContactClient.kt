package com.example.jsoncontactk

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ContactClient {
    @GET("?results=2&inc=gender,name,email,picture")
    fun reposForUser(): Call<List<Result>>
}
