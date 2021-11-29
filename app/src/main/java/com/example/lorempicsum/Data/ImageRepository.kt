package com.example.lorempicsum.Data

import com.example.lorempicsum.Model.PicsumImageDetails
import com.example.lorempicsum.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepository {

    private val imageApi = NetworkService.imageNetworkInterface

    suspend fun getImageDetails(imageId: Int): PicsumImageDetails {
        return withContext(Dispatchers.IO) {
            val response = imageApi.getImageDetails(imageId)
            val body = response.body()
            body?.let {
                return@withContext it
            } ?: run {
                throw Exception("No data available")
            }
        }
    }

}