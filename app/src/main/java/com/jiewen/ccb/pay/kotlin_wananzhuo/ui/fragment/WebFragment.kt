package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseFragment
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.FragmentWebBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.WebFragmentViewHolder

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/10  4:30 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class eWebFragment :BaseFragment<FragmentWebBinding ,WebFragmentViewHolder>(WebFragmentViewHolder::class.java) {
    override fun initView() {

    }

    override fun getLayoutId(): Int = R.layout.fragment_web
}