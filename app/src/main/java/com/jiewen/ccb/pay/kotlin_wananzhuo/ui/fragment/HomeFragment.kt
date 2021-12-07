package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jiewen.ccb.pay.kotlin_wananzhuo.Config
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter.ImageAdapter
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.HomeFragmentViewModel
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/64:28 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeFragment :Fragment() {
        lateinit var  homeFragmentViewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentViewModel =  ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        homeFragmentViewModel.getBanner()
        homeFragmentViewModel.bannerData.observe(viewLifecycleOwner){
            banner_view.adapter = ImageAdapter(it)
            banner_view.addBannerLifecycleObserver(this)
                .setIndicator( CircleIndicator(activity))
        }
        return inflater.inflate(R.layout.fragment_home,container,false)
    }
}