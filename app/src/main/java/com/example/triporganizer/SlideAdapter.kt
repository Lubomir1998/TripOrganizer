package com.example.triporganizer

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class SlideAdapter(val context: Context, val listImg: ArrayList<Int>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = listImg.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imgview = ImageView(context)
        imgview.scaleType = ImageView.ScaleType.CENTER_CROP
        imgview.setImageResource(listImg[position])
        container.addView(imgview, 0)
        return imgview
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}