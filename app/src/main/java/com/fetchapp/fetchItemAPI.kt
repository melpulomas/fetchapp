package com.fetchapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface fetchItemAPI {

    @GET( "/hiring.json")
    suspend fun getFetchItems(): Response<List<fetchitem>>


}