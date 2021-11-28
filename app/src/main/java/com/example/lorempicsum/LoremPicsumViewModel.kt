package com.example.lorempicsum

import android.app.Application
import androidx.lifecycle.*
import com.koushikdutta.ion.Ion
import com.koushikdutta.ion.builder.Builders
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.random.Random

class LoremPicsumViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    /* = = = data = = = */
    private val repository: ImageRepository = ImageRepository()

    fun init() {
        this.initDateTimeDisplayTimer()
    }

    /* = = = observables = = = */
    private var _picsumImageDetails: MutableLiveData<PicsumImageDetails?> = MutableLiveData()
    val picsumImageDetails: LiveData<PicsumImageDetails?>
        get() = _picsumImageDetails

    private var _currentDateString: MutableLiveData<String?> = MutableLiveData()
    val currentDateString: LiveData<String?>
        get() = _currentDateString

    private var _loadTimeString: MutableLiveData<String?> = MutableLiveData()
    val loadTimeString: LiveData<String?>
        get() = _loadTimeString

    private var _imageRequestBuilder: MutableLiveData<Builders.Any.B?> = MutableLiveData()
    val imageRequestBuilder: LiveData<Builders.Any.B?>
        get() = _imageRequestBuilder


//    fun fetchImage(): Builders.Any.B? {
//        // for load duration calculation
//        val imageFetchStartTime = System.nanoTime()
//
//        // load random image
//        val seed = Random.nextInt(0, 100000) // prevent caching
//        val ionImageRequestBuilder = Ion.with(context)
//            .load("https://picsum.photos/seed/${seed}/200/300")
//
//        // fetch metadata
//        ionImageRequestBuilder
//            .asString()
//            .withResponse()
//            .setCallback { e, result ->
//                if (e == null) {
//                    this.updateLoadTimeDisplay(imageFetchStartTime)
//                    this.parseHeadersAndFetchImageDetails(result)
//                }
//            }
//
//        // return builder
//        return ionImageRequestBuilder
//    }

    fun launchFetchImage() {
        viewModelScope.launch {
            fetchImage()
        }
    }

    private fun fetchImage() {
        // for load duration calculation
        val imageFetchStartTime = System.nanoTime()

        // load random image
        val seed = Random.nextInt(0, 100000) // prevent caching
        val imageUrl = "https://picsum.photos/seed/${seed}/200/300"
        val ionImageRequestBuilder = Ion.with(context).load(imageUrl)

        // fetch metadata
        ionImageRequestBuilder
            .asString()
            .withResponse()
            .setCallback { e, result ->
                if (e == null) {
                    this.updateLoadTimeDisplay(imageFetchStartTime)
                    this.parseHeadersAndFetchImageDetails(result)
                }
            }

        // broadcast builder
        this._imageRequestBuilder.postValue(ionImageRequestBuilder)
    }

    private fun updateLoadTimeDisplay(imageFetchStartTime: Long) {
        val endTime = System.nanoTime()
        val nanoSecondDiff = endTime - imageFetchStartTime
        val millisecondDiff = nanoSecondDiff / 1000000
        this._loadTimeString.postValue("${millisecondDiff}ms")
    }

    private fun parseHeadersAndFetchImageDetails(response: com.koushikdutta.ion.Response<String>) {
        val headerDict = response.headers.headers
        headerDict.get("Picsum-Id")?.let { str ->
            str.toIntOrNull()?.let { imageId ->
                this.getImageDetails(imageId)
            }
        }
    }

    private fun getImageDetails(imageId: Int) {
        viewModelScope.launch {
            try {
                val details = repository.getImageDetails(imageId)
                _picsumImageDetails.postValue(details)
            } catch (e: Exception) {
                // TODO: Show error message to User
            }
        }
    }

    private fun initDateTimeDisplayTimer() {
        val sdf = SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss a", Locale.getDefault())

        fixedRateTimer("timer", true, 0L, 1000) {
            val date = Calendar.getInstance().time
            val currentDate = sdf.format(date)
            this@LoremPicsumViewModel._currentDateString.postValue(currentDate)
        }
    }
}
