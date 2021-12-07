package com.jiewen.ccb.pay.kotlin_wananzhuo.model

import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseResponse
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.netWork.AppServices
import com.jiewen.ccb.pay.kotlin_wananzhuo.netWork.RetrofitManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:54 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */

//处理网络请求或是操作数据库
class HomeModel {

    fun requestbannerData() {
        RetrofitManager.retrofitManager.creatApiServices(AppServices::class.java).getBanners()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<BaseResponse<ArrayList<BannerBean>>>{
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(value: BaseResponse<ArrayList<BannerBean>>?) {

                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {
                }

            })


    }
}