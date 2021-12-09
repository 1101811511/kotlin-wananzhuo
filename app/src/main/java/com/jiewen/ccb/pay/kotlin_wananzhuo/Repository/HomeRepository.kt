package com.jiewen.ccb.pay.kotlin_wananzhuo.Repository

import androidx.paging.PagedList
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.HomeArticleListBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.netWork.AppServices
import com.jiewen.ccb.pay.kotlin_wananzhuo.netWork.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:37 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeRepository {

    suspend fun requestBanner(): ArrayList<BannerBean> =
        RetrofitManager.retrofitManager.creatApiServices(AppServices::class.java).getBanners().data

    suspend fun requestArticleList():ArrayList<TopArticleListBean> =
        RetrofitManager.retrofitManager.creatApiServices(AppServices::class.java).getTopArticles().data


    suspend fun requestHomeArticleList():HomeArticleListBean =
        RetrofitManager.retrofitManager.creatApiServices(AppServices::class.java).getArticles(0).data



}