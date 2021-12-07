package com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jiewen.ccb.pay.kotlin_wananzhuo.Repository.HomeRepository
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:35 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeFragmentViewModel :ViewModel(){
    val bannerData:MutableLiveData<BannerBean> = MutableLiveData()

     private val homeeRepository = HomeRepository()



}