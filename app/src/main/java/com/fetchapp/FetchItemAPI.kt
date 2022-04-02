package com.fetchapp

import retrofit2.Response
import retrofit2.http.GET

interface FetchItemAPI {

    @GET( "/hiring.json")
    suspend fun getFetchItems(): Response<List<FetchItem>>


}