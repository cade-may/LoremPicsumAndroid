package com.example.lorempicsum.Data

import com.example.lorempicsum.Features.ImageDisplay.Model.PicsumImageDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageNetworkInterface {
    @GET("id/{imageId}/info")
    suspend fun getImageDetails(
        @Path("imageId") imageId: Int,
    ): Response<PicsumImageDetails>
}
