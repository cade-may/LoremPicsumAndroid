package com.example.lorempicsum

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageNetworkInterface {
    @GET("id/{imageId}/info")
    suspend fun getImageDetails(
        @Path("imageId") imageId: Int,
    ): Response<PicsumImageDetails>
}
