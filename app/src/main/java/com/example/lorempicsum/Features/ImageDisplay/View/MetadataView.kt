package com.example.lorempicsum.Features.ImageDisplay.View

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
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
//        textView.typeface = ResourcesCompat.getFont(context, R.font.lineto_circular_book)
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
//        textView.typeface = ResourcesCompat.getFont(context, R.font.lineto_circular_book)
        textView.textSize = 14F
        textView.maxLines = 1
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.text = "222"
        return textView
    }

}


//
//
//class LoremPicsumFragment : Fragment() {
//
//    private lateinit var root: LinearLayout
//
//    private lateinit var dateTimeTextView: TextView
//    private lateinit var imageIdView: MetadataView
//    private lateinit var widthView: MetadataView
//    private lateinit var heightView: MetadataView
//    private lateinit var loadTimeView: MetadataView
//    private lateinit var roundedImageView: RoundedImageView
//    private lateinit var authorNameView: MetadataView
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return this.initRoot()
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        initLayout()
//        setupObservers()
//    }
//
//    private fun initRoot(): LinearLayout {
//        root = LinearLayout(context)
//        root.orientation = LinearLayout.VERTICAL
//        root.layoutParams = ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        )
//        root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
//        return root
//    }
//
//    private fun initLayout() {
//        // set root padding
//        val padding = 10
//        this.root.setPadding(padding.toPx(), padding.toPx(), padding.toPx(), padding.toPx())
//
//        // dateTimeTextView
//        dateTimeTextView = initDateTextView()
//        this.root.addView(dateTimeTextView)
//
//        // imageIdView
//        imageIdView = MetadataView(requireContext())
//        imageIdView.leftTextView.text = "Image id:"
//        this.root.addView(imageIdView)
//
//        // widthMetadataView
//        widthView = MetadataView(requireContext())
//        widthView.leftTextView.text = "Width:"
//        this.root.addView(widthView)
//
//        // heightView
//        heightView = MetadataView(requireContext())
//        heightView.leftTextView.text = "Height:"
//        this.root.addView(heightView)
//
//        // loadTimeView
//        loadTimeView = MetadataView(requireContext())
//        loadTimeView.leftTextView.text = "Load time:"
//        this.root.addView(loadTimeView)
//
//        // roundedImageView
//        roundedImageView = RoundedImageView(requireContext())
//        val fillHeightLayoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT,
//            1F
//        )
//        roundedImageView.layoutParams = fillHeightLayoutParams
//        this.root.addView(roundedImageView)
//
//        // authorNameView
//        authorNameView = MetadataView(requireContext())
//        authorNameView.leftTextView.text = "Author name:"
//        this.root.addView(authorNameView)
//    }
//
//    private fun initDateTextView(): TextView {
//        val textView = TextView(context)
//        textView.layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
//        textView.textSize = 15F
//        textView.maxLines = 1
//        textView.ellipsize = TextUtils.TruncateAt.END
//        textView.text = "today's date"
//        textView.gravity = Gravity.CENTER
//        return textView
//    }
//
//    private fun setupObservers() {
//
//    }
//}
