package com.example.musico

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiInterface {
    @Headers("X-RapidAPI-Key:089fc7b385mshc60d23f70102db7p14e367jsndf7d0a70cb6c","X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String) : Call<MyData>
}