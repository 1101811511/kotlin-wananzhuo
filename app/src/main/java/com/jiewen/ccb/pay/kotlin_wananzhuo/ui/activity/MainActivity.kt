package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.jiewen.ccb.pay.kotlin_wananzhuo.Config
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseActivity
import com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment.*
import kotlinx.android.synthetic.main.activtiy_main.*

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/63:33 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class MainActivity : BaseActivity() {
    private var homeFragment: HomeFragment? = null
    private var proJectFragment: ProJectFragment? = null
    private var guangFragment: GuangFragment? = null
    private var publicFragment: PublicFragment? = null
    private var mineFragment: MineFragment? = null
    private var currentFragmentIndex: Int = 0
    var lastFragmentIndex = -1

    override fun initView() {
        showFragment(currentFragmentIndex)
        bottom_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_page -> {
                    showFragment(Config.HOME_FRAGMENT)
                }
                R.id.project_page -> {
                    showFragment(Config.PROJECT_FRAGMENT)
                }
                R.id.guang_page -> {
                    showFragment(Config.GUANG_FRAGMENT)
                }
                R.id.public_page -> {
                    showFragment(Config.PUBLIC_FRASGMENT)
                }
                R.id.mine_page ->{
                    showFragment(Config.MINE_FRGMENT)
                }
            }
            true

        }
    }

    override fun getLayOutId(): Int = R.layout.activtiy_main

    //通过显隐来控制fragment的显示
    private fun showFragment(index: Int) {

        currentFragmentIndex = index
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        hideFragment(fragmentTransaction)
        lastFragmentIndex = index
        when (index) {
            //很奇怪这里为啥不能用
            Config.HOME_FRAGMENT -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                    fragmentTransaction.add(R.id.frame_group, homeFragment!!)
                }
                fragmentTransaction.show(homeFragment!!)
            }
            Config.PROJECT_FRAGMENT -> {
                if (proJectFragment == null) {
                    proJectFragment = ProJectFragment()
                    fragmentTransaction.add(R.id.frame_group, proJectFragment!!)
                }
                fragmentTransaction.show(proJectFragment!!)
            }
            Config.GUANG_FRAGMENT -> {
                if (guangFragment == null) {
                    guangFragment = GuangFragment()
                    fragmentTransaction.add(R.id.frame_group, guangFragment!!)
                }
                fragmentTransaction.show(guangFragment!!)

            }
            Config.PUBLIC_FRASGMENT -> {
                if (publicFragment == null) {
                    publicFragment = PublicFragment()
                    fragmentTransaction.add(R.id.frame_group, publicFragment!!)
                }
                fragmentTransaction.show(publicFragment!!)
            }
            Config.MINE_FRGMENT -> {
                if (mineFragment == null) {
                    mineFragment = MineFragment()
                    fragmentTransaction.add(R.id.frame_group, mineFragment!!)
                }
                fragmentTransaction.show(mineFragment!!)
            }
        }
        fragmentTransaction.commit()

    }

    private fun hideFragment(transation: FragmentTransaction) {
        when (lastFragmentIndex) {
            Config.HOME_FRAGMENT -> {
                homeFragment?.let {
                    transation.hide(it)
                }
            }
            Config.PROJECT_FRAGMENT -> {
                proJectFragment?.let {
                    transation.hide(it)
                }
            }
            Config.GUANG_FRAGMENT -> {
                guangFragment?.let {
                    transation.hide(it)
                }

            }
            Config.PUBLIC_FRASGMENT -> {
                publicFragment?.let {
                    transation.hide(it)
                }
            }
            Config.MINE_FRGMENT -> {
                mineFragment?.let {
                    transation.hide(it)
                }
            }
        }
    }
}