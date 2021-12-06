package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jiewen.ccb.pay.kotlin_wananzhuo.R

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/64:33 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class ProJectFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_project,container,false)
    }
}