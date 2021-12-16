package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.viewpager2.widget.ViewPager2
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseFragment
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.FragmentMainBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter.FragmentAdapter
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.MainFragmentViewModel

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/16  9:17 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class MainFragment :
    BaseFragment<FragmentMainBinding, MainFragmentViewModel>(MainFragmentViewModel::class.java) {

    override fun getLayoutId(): Int = R.layout.fragment_main

    private val fragmentList = arrayListOf<Fragment>()
    private val homeFragment: HomeFragment by lazy {
        HomeFragment()
    }
    private val proJectFragment: ProJectFragment by lazy {
        ProJectFragment()
    }
    private val guangFragment: GuangFragment by lazy {
        GuangFragment()
    }
    private val publicFragment: PublicFragment by lazy {
        PublicFragment()
    }
    private val mineFragment: MineFragment by lazy {
        MineFragment()
    }


    init {
        fragmentList.apply {
            add(homeFragment)
            add(proJectFragment)
            add(guangFragment)
            add(publicFragment)
            add(mineFragment)
        }
    }

    override fun initView() {
        val fragmentAdapter = FragmentAdapter(activity, fragmentList)
        databing.viewPager.adapter = fragmentAdapter
        databing.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                databing.bottomView.menu.getItem(position).setChecked(true)
            }
        })
        databing.bottomView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    databing.viewPager.setCurrentItem(0, false)
                    currentItem(0)
                }
                R.id.proJectFragment -> {
                    currentItem(1)
                }
                R.id.guangFragment -> {
                    currentItem(2)
                }
                R.id.publicFragment -> {
                    currentItem(3)
                }
                R.id.mineFragment -> {
                    currentItem(4)
                }
            }
            true

        }
    }

   private fun currentItem(item: Int) {
        databing.viewPager.setCurrentItem(item, false)
    }


}