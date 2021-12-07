package com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiewen.ccb.pay.kotlin_wananzhuo.Config
import com.jiewen.ccb.pay.kotlin_wananzhuo.Repository.HomeRepository
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:35 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeFragmentViewModel :ViewModel(){

    val bannerData:MutableLiveData<ArrayList<BannerBean>> = MutableLiveData()

     private val homeRepository by lazy {
         HomeRepository()
     }



    fun getBanner(){
        Log.i(Config.TAG,"11111")
        viewModelScope.launch {
                runCatching {
                    bannerData.value =  homeRepository.requestBanner()
                }.isSuccess
            }
    }
}