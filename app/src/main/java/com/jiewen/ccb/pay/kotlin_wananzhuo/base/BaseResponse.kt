package com.jiewen.ccb.pay.kotlin_wananzhuo.base

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/63:10 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
data class BaseResponse<T>(val data:T,val errorCode:Int,val errorMsg:String)
