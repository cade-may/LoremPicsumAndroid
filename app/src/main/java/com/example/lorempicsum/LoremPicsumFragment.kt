package com.example.lorempicsum

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.koushikdutta.ion.Ion
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class LoremPicsumFragment : Fragment() {

    private lateinit var root: LoremPicsumFragmentView

    private val viewModel: LoremPicsumViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return this.initRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        fetchImage()
        initActions()
        this.viewModel.init()
    }

    private fun initActions() {
        this.root.roundedImageView.mainImageView.setOnClickListener {
            this.fetchImage()
        }
    }

    private fun fetchImage() {
        this.viewModel.launchFetchImage()
    }

    private fun initRoot(): LoremPicsumFragmentView {
        root = LoremPicsumFragmentView(requireContext())
        return root
    }

    private fun setupObservers() {
        observeDate()
        observeLoadTime()
        observeImageDetails()
        observeImageRequest()
    }

    private fun observeImageRequest() {
        this.viewModel.imageRequestBuilder.observe(viewLifecycleOwner) { imageRequestBuilder ->
            imageRequestBuilder?.let {
                it.intoImageView(root.roundedImageView.mainImageView)
            }
        }
    }

    private fun observeLoadTime() {
        this.viewModel.loadTimeString.observe(viewLifecycleOwner) { time ->
            time?.let {
                this.root.loadTimeView.rightTextView.text = it
            } ?: run {
                this.root.loadTimeView.rightTextView.text = " "
            }
        }
    }

    private fun observeDate() {
        this.viewModel.currentDateString.observe(viewLifecycleOwner) { date ->
            date?.let {
                this.root.dateTimeTextView.text = it
            } ?: run {
                this.root.dateTimeTextView.text = " "
            }
        }
    }

    private fun observeImageDetails() {
        this.viewModel.picsumImageDetails.observe(viewLifecycleOwner) {
            val picsumImageDetails = it ?: return@observe
            this.root.imageIdView.rightTextView.text = picsumImageDetails.id
            this.root.widthView.rightTextView.text = "${picsumImageDetails.width}"
            this.root.heightView.rightTextView.text = "${picsumImageDetails.height}"
            this.root.authorNameView.rightTextView.text = picsumImageDetails.author
        }
    }

//    private fun fetchImage() {
//        // load random image
//        val seed = Random.nextInt(0, 100000) // prevent caching
//        val loaded = Ion.with(context)
//            .load("https://picsum.photos/seed/${seed}/200/300")
//
//        // place in imageview
//        loaded.intoImageView(root.roundedImageView.mainImageView)
//
//        // fetch metadata
//        loaded
//            .asString()
//            .withResponse()
//            .setCallback { e, result ->
//                if (e == null) {
//                    this.viewModel.parseHeadersAndFetchImageDetails(result)
//                }
//            }
//    }
}
