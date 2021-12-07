package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseFragment
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.FragmentHomeBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter.ImageAdapter
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.HomeFragmentViewModel
import com.youth.banner.indicator.CircleIndicator

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/64:28 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(HomeFragmentViewModel::class.java) {

    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun initView() {
        viewModel.bannerData.observe(viewLifecycleOwner) {
            databing.bannerView.apply {
                adapter = ImageAdapter(it)
                indicator = CircleIndicator(activity)
                addBannerLifecycleObserver(viewLifecycleOwner)
            }
        }
        viewModel.getBanner()
    }

}