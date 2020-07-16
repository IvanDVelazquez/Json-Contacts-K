package com.example.jsoncontactk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var API_BASE_URL = "https://randomuser.me/api/"

        var httpClient = OkHttpClient.Builder()

        var builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )

        var retrofit = builder
            .client(
                httpClient.build()
            )
            .build()

        var client: ContactClient = retrofit.create<ContactClient>(ContactClient::class.java)


        // Fetch a list of the Github repositories.
        var call = client.reposForUser()
        call.enqueue(object : Callback<List<Result>> {
            override fun onResponse(
                call: Call<List<Result>>,
                response: Response<List<Result>>
            ) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                if(response.isSuccessful){
                    val contactsList: List<Result> = response.body()!!
                    println(contactsList)
                    Log.d("CNTC",contactsList.toString())
                }
            }

            override fun onFailure(
                call: Call<List<Result>>,
                t: Throwable?
            ) {
                // the network call was a failure
                // TODO: handle error
                Log.d("CNTC","it couldn't be")
                Log.e("CNTC","exception",t)

            }
        })
    }


}