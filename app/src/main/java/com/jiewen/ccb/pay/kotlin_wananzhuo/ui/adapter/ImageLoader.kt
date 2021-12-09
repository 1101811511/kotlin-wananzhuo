package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean
import com.youth.banner.adapter.BannerAdapter
import java.util.ArrayList

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  4:24 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class ImageAdapter(data: MutableList<BannerBean>) : BannerAdapter<BannerBean, ImageAdapter.ImageHolder>(data) {

    class ImageHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ImageHolder {
        val imageView = ImageView(parent?.context)
        val parmas = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.layoutParams =parmas
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        return  ImageHolder(imageView)
    }

    override fun onBindView(
        holder: ImageHolder?,
        data: BannerBean?,
        position: Int,
        size: Int
    ) {

        val roundedCorners = RoundedCorners(10)
        val option = RequestOptions.bitmapTransform(roundedCorners)
        Glide.with(holder!!.imageView).load(data?.imagePath).apply(option).into(holder.imageView)

    }
}