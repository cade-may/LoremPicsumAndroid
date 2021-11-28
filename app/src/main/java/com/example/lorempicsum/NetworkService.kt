package com.example.lorempicsum

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.fixedRateTimer

object NetworkService {
    private const val BASE_URL = "https://picsum.photos"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val imageNetworkInterface: ImageNetworkInterface
            by lazy { retrofit.create(ImageNetworkInterface::class.java) }
}

data class PicsumImageDetails(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
)
