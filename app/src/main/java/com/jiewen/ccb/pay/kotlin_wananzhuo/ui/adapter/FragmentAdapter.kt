package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/16  2:51 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class FragmentAdapter(activity: FragmentActivity?, val itemList:ArrayList<Fragment>) :FragmentStateAdapter(
    activity!!
) {
    override fun getItemCount(): Int = itemList.size

    override fun createFragment(position: Int): Fragment  = itemList[position]
}