package com.jiewen.ccb.pay.kotlin_wananzhuo.Repository

import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.netWork.AppServices
import com.jiewen.ccb.pay.kotlin_wananzhuo.netWork.RetrofitManager

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:37 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeRepository  {

   suspend  fun  requestBanner():ArrayList<BannerBean> = RetrofitManager.retrofitManager.creatApiServices(AppServices::class.java).getBanners().data


}