package com.app.simon.anidemo

import android.animation.*
import android.view.View
import android.view.ViewGroup

/**
 * desc: 自定义布局动画
 * date: 2017/12/12
 *
 * @author xw
 */
class CustomerLayoutTransition(private val view: View, listener: OnTransitionListener? = null) : LayoutTransition() {

    init {
        addTransitionListener(object : LayoutTransition.TransitionListener {
            override fun startTransition(transition: LayoutTransition?, container: ViewGroup?, view: View?, transitionType: Int) {
                listener?.startTransition()
            }

            override fun endTransition(transition: LayoutTransition?, container: ViewGroup?, view: View?, transitionType: Int) {
                listener?.endTransition()
            }
        })

        //        APPEARING —— 元素在容器中出现时所定义的动画。
        //        DISAPPEARING —— 元素在容器中消失时所定义的动画。
        //        CHANGE_APPEARING —— 由于容器中要显现一个新的元素，其它需要变化的元素所应用的动画
        //        CHANGE_DISAPPEARING —— 当容器中某个元素消失，其它需要变化的元素所应用的动画

        //        enableTransitionType(LayoutTransition.CHANGING) //变化的时候也播放动画
        setStartDelay(LayoutTransition.APPEARING, 0) //源码中带有默认300毫秒的延时，需要移除，不然view添加效果不好！！
        setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, 0) //源码中带有默认300毫秒的延时，需要移除，不然view添加效果不好！！
    }

    /** 添加显示的动画 */
    fun setAppearingAnim(duration: Long = 200): CustomerLayoutTransition {
        setAnimator(LayoutTransition.APPEARING, getAppearingAnimation(view))
        setDuration(LayoutTransition.APPEARING, duration)
        return this
    }

    /** 添加隐藏的动画 */
    fun setDisappearingAnim(duration: Long = 200): CustomerLayoutTransition {
        setAnimator(LayoutTransition.DISAPPEARING, getDisappearingAnimation(view))
        setDuration(LayoutTransition.DISAPPEARING, duration)
        return this
    }

    /** 添加变化显示的动画 */
    fun setChangeAppearingAnim(duration: Long = 200): CustomerLayoutTransition {
        setAnimator(LayoutTransition.CHANGE_APPEARING, getAppearingChangeAnimation(view))
        setDuration(LayoutTransition.CHANGE_APPEARING, duration)
        return this
    }

    /** 添加变化隐藏的动画 */
    fun setChangeDisappearingAnim(duration: Long = 200): CustomerLayoutTransition {
        setAnimator(LayoutTransition.CHANGE_DISAPPEARING, getDisappearingChangeAnimation(view))
        setDuration(LayoutTransition.CHANGE_DISAPPEARING, duration)
        return this
    }

    /** 显示的动画 */
    private fun getAppearingAnimation(view: View): Animator {
        val mSet = AnimatorSet()
        mSet.playTogether(
                //                ObjectAnimator.ofFloat(view, "ScaleX", 2.0f, 1.0f),
                //                ObjectAnimator.ofFloat(view, "ScaleY", 2.0f, 1.0f),
                ObjectAnimator.ofFloat(view, "Alpha", 0.0f, 1.0f),
                ObjectAnimator.ofFloat(view, "translationX", 400f, 0f))
        return mSet
    }

    /** 隐藏的动画 */
    private fun getDisappearingAnimation(view: View): Animator {
        val mSet = AnimatorSet()
        mSet.playTogether(
                ObjectAnimator.ofFloat(view, "ScaleX", 1.0f, 0f),
                ObjectAnimator.ofFloat(view, "ScaleY", 1.0f, 0f),
                ObjectAnimator.ofFloat(view, "Alpha", 1.0f, 0.0f),
                ObjectAnimator.ofFloat(view, "translationX", 0f, 400f))
        return mSet
    }

    /** 显示变化的动画 */
    private fun getAppearingChangeAnimation(view: View): Animator {
        val pvhLeft = PropertyValuesHolder.ofInt("left", 0, 0)
        val pvhTop = PropertyValuesHolder.ofInt("top", 0, 0)
        val pvhRight = PropertyValuesHolder.ofInt("right", 0, 0)
        val pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 0)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 2f, 1.0f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 2f, 1.0f)
        return ObjectAnimator.ofPropertyValuesHolder(view, pvhLeft, pvhTop, pvhRight, pvhBottom, scaleX, scaleY)
    }

    /** 隐藏变化的动画 */
    private fun getDisappearingChangeAnimation(view: View): Animator {
        val pvhLeft = PropertyValuesHolder.ofInt("left", 0, 0)
        val pvhTop = PropertyValuesHolder.ofInt("top", 0, 0)
        val pvhRight = PropertyValuesHolder.ofInt("right", 0, 0)
        val pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 0)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0f, 1.0f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0f, 1.0f)
        val rotate = PropertyValuesHolder.ofFloat("rotation", 0f, 0f, 0f)
        return ObjectAnimator.ofPropertyValuesHolder(view, pvhLeft, pvhTop, pvhRight, pvhBottom, scaleX, scaleY, rotate)
    }

    interface OnTransitionListener {
        fun startTransition()
        fun endTransition()
    }
}