package com.example.lorempicsum.Features.ImageDisplay.View

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.lorempicsum.R
import com.example.lorempicsum.toPx

class MetadataView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    lateinit var leftTextView: TextView
    lateinit var rightTextView: TextView

    init {
        this.initSelf()
        this.initLayout()
    }

    private fun initSelf() {
        this.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        this.id = View.generateViewId()
        this.orientation = LinearLayout.HORIZONTAL
        this.gravity = Gravity.CENTER_VERTICAL
    }

    private fun initLayout() {
        // leftTextView
        leftTextView = initLeftTextView()
        this.addView(leftTextView)

        // rightTextView
        rightTextView = initRightTextView()
        this.addView(rightTextView)
    }

    private fun initLeftTextView(): TextView {
        val textView = TextView(context)
        textView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        textView.setTypeface(null, Typeface.BOLD)
        textView.textSize = 16F
        textView.maxLines = 1
        textView.setPadding(0, 0, 4.toPx(), 0)
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.text = "Width"
        return textView
    }

    private fun initRightTextView(): TextView {
        val textView = TextView(context)
        textView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView.setTextColor(ContextCompat.getColor(context, R.color.cardview_dark_background))
        textView.textSize = 14F
        textView.maxLines = 1
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.text = "222"
        return textView
    }

}
