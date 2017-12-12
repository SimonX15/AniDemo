package com.app.simon.anidemo

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout


/**
 * desc:
 * date: 2017/12/11
 *
 * @author xw
 */
class ItemLinearLayout(context: Context?, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    init {
        layoutTransition = CustomerLayoutTransition(this, object : CustomerLayoutTransition.OnTransitionListener {
            override fun startTransition() {

            }

            override fun endTransition() {

            }
        })
                        .setAppearingAnim()
                        .setDisappearingAnim()
//                        .setChangeAppearingAnim()
//                        .setChangeDisappearingAnim()
    }

    fun addItemAtFirst(itemView: ItemView) {
        addView(itemView, 0)
    }

    fun addItemAtLast(itemView: ItemView) {
        addView(itemView)
    }
}