package com.example.lorempicsum

import com.example.lorempicsum.Data.ImageNetworkInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "https://picsum.photos"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val imageNetworkInterface: ImageNetworkInterface
            by lazy { retrofit.create(ImageNetworkInterface::class.java) }
}
