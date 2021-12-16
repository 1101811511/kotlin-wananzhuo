package com.jiewen.ccb.pay.kotlin_wananzhuo.netWork

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jiewen.ccb.pay.kotlin_wananzhuo.Config
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:41 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class RetrofitManager {
    //单例模式
    private object Manager {
        val manager = RetrofitManager()
    }

    //静态变凉
    companion object {
        val retrofitManager = Manager.manager
    }

    //初始化retrofit
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }


    //创建services
    fun <T> creatApiServices(classes: Class<T>): T {
        return initRetrofit().create(classes)
    }
    //日志打印
    fun getRequestLog():Interceptor{
        return HttpLoggingInterceptor("贝吉塔").apply {
            setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            setColorLevel(Level.INFO)
        }
    }


    //初始化okhttp
    private val okHttpClient: OkHttpClient
        get() {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(getRequestLog())
                .build()
        }
}