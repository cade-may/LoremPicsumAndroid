package com.example.lorempicsum.Features.ImageDisplay.View

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.lorempicsum.R
import com.example.lorempicsum.toPx
import com.google.android.material.card.MaterialCardView

class RoundedImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    init {
        this.initialSetup()
        this.initLayout()
    }

    lateinit var mainImageView: ImageView

    private fun initialSetup() {
        this.id = View.generateViewId()

        this.preventCornerOverlap = true
        this.useCompatPadding = true
        this.radius = 20F
        this.cardElevation = 12F
        this.isClickable = true
        this.strokeColor = ContextCompat.getColor(context, R.color.black)
        this.strokeWidth = 4.toPx()
    }

    private fun initLayout() {
        mainImageView = createMainImageView()
        this.addView(mainImageView)
    }

    private fun createMainImageView(): ImageView {
        val iv = ImageView(context)
        iv.setImageResource(R.drawable.ic_launcher_foreground)
        iv.scaleType = ImageView.ScaleType.CENTER_CROP
        iv.setBackgroundColor(ContextCompat.getColor(context, R.color.cardview_shadow_start_color))
        val params = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        iv.layoutParams = params
        return iv
    }

}
