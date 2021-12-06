package com.jiewen.ccb.pay.kotlin_wananzhuo.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/66:01 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayOutId())
        initView()
        initData()
    }


    abstract fun initView()

    //看实际情况实现
    fun initData() {}

    abstract fun getLayOutId(): Int

    //跳转，先不使用anko库，后边可能会用navigation
    fun <T> startActivtiy(clazz: Class<T>, bundle: Bundle?) {
        val intent = Intent(this, clazz).apply {
            bundle?.let {
                putExtras(it)
            }
        }
        startActivity(intent)

    }
}