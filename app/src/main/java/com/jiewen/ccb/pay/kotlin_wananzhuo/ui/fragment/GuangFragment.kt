package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import kotlinx.android.synthetic.main.fragment_guangchang.*
import kotlinx.android.synthetic.main.fragment_guangchang.view.*

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/64:28 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class GuangFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_guangchang,container,false)
        view.guangFragment.setOnClickListener {

            val controller = Navigation.findNavController(it)
            controller.navigate(R.id.action_guangFragment_to_publicFragment)


        }

        return view
    }
}