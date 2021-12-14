package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.jiewen.ccb.pay.kotlin_wananzhuo.Config
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseFragment
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.FragmentHomeBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter.HomeArticleAdapter
import com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter.ImageAdapter
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.HomeFragmentViewModel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.youth.banner.indicator.CircleIndicator

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/64:28 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(HomeFragmentViewModel::class.java),
    OnRefreshListener, OnLoadMoreListener {
    override fun getLayoutId(): Int = R.layout.fragment_home

    private val homeArticleAdapter: HomeArticleAdapter by lazy {
        HomeArticleAdapter(requireContext())
    }

    override fun initView() {
        //请求接口
        viewModel.getBannerTopArticleList()
        databing.refreshLayout.setOnRefreshListener(this)
        databing.refreshLayout.setOnLoadMoreListener(this)
        //监听banner返回的数据
        viewModel.bannerData.observe(viewLifecycleOwner) {
            databing.bannerView.apply {
                adapter = ImageAdapter(it)
                indicator = CircleIndicator(activity)
                addBannerLifecycleObserver(viewLifecycleOwner)
            }
        }
        viewModel.mPageData.observe(viewLifecycleOwner) {
            databing.refreshLayout.finishRefresh()
            databing.refreshLayout.finishLoadMore()
            if (it.size == 0) {
                databing.refreshLayout.finishLoadMoreWithNoMoreData()
            } else {
                homeArticleAdapter.submitList(it)
            }
        }
        databing.recyclerView.adapter = homeArticleAdapter
         homeArticleAdapter.setItemClickListener = {
             postion: Int, dataBean: TopArticleListBean ->
//                NavController(requireContext()).navigate(R.id.frame_group)
//              navigation().navigate(R.id.action_homeFragment_to_webFragment)
             Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_webFragment)
             Log.i(Config.TAG,"当前的位置${postion}-----${dataBean.toString()}")
         }

    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        viewModel.getBannerTopArticleList()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        viewModel.loadMoreArticleList()
    }

}