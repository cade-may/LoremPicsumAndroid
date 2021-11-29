package com.example.lorempicsum.Features.ImageDisplay.View

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.lorempicsum.R
import com.example.lorempicsum.toPx

class LoremPicsumFragmentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    lateinit var dateTimeTextView: TextView
    lateinit var imageIdView: MetadataView
    lateinit var widthView: MetadataView
    lateinit var heightView: MetadataView
    lateinit var loadTimeView: MetadataView
    lateinit var roundedImageView: RoundedImageView
    lateinit var authorNameView: MetadataView

    init {
        this.initSelf()
        this.initLayout()
    }

    private fun initSelf() {
        this.orientation = LinearLayout.VERTICAL
        this.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        this.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        this.id = View.generateViewId()
        val padding = 10
        this.setPadding(padding.toPx(), padding.toPx(), padding.toPx(), padding.toPx())
    }

    private fun initLayout() {
        // dateTimeTextView
        dateTimeTextView = initDateTextView()
        this.addView(dateTimeTextView)

        // imageIdView
        imageIdView = MetadataView(context)
        imageIdView.leftTextView.text = "Image id:"
        this.addView(imageIdView)

        // widthMetadataView
        widthView = MetadataView(context)
        widthView.leftTextView.text = "Width:"
        this.addView(widthView)

        // heightView
        heightView = MetadataView(context)
        heightView.leftTextView.text = "Height:"
        this.addView(heightView)

        // loadTimeView
        loadTimeView = MetadataView(context)
        loadTimeView.leftTextView.text = "Load time:"
        this.addView(loadTimeView)

        // roundedImageView
        roundedImageView = RoundedImageView(context)
        val fillHeightLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            1F
        )
        roundedImageView.layoutParams = fillHeightLayoutParams
        this.addView(roundedImageView)

        // authorNameView
        authorNameView = MetadataView(context)
        authorNameView.leftTextView.text = "Author name:"
        this.addView(authorNameView)
    }

    private fun initDateTextView(): TextView {
        val textView = TextView(context)
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        textView.setTypeface(null, Typeface.BOLD)
        textView.textSize = 15F
        textView.maxLines = 1
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.text = "today's date"
        textView.gravity = Gravity.CENTER
        return textView
    }

}