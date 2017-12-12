package com.app.simon.anidemo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item.view.*

/**
 * desc:
 * date: 2017/12/11
 *
 * @author xw
 */
class ItemView(context: Context?, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    private val view = LayoutInflater.from(context).inflate(R.layout.item, null)

        init {
            addView(view)
        }

    fun setData(title: String): ItemView {
        view.tv_title.text = title
        return this
    }

}