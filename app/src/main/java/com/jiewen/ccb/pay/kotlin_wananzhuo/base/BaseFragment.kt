package com.jiewen.ccb.pay.kotlin_wananzhuo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jiewen.ccb.pay.kotlin_wananzhuo.R

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  6:00 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
abstract class BaseFragment<DB : ViewDataBinding,VM :ViewModel>( val mClass:Class<VM>) : Fragment() {
    lateinit var databing: DB
     val viewModel by lazy {
         ViewModelProvider(this).get(mClass)
     }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databing = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)

        //初始化viewModel
        initViewModel()
        //初始化相关的操作
        initView()
        return databing.root
    }
        //先保留吧
     fun initViewModel(){

     }

    abstract fun initView()

    abstract fun getLayoutId(): Int






}