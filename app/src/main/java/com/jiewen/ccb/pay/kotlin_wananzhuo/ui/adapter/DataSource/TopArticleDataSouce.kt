package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter.DataSource

import androidx.paging.PositionalDataSource
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/8  11:01 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class TopArticleDataSouce :PositionalDataSource<TopArticleListBean>() {
    //初始化第一页数据
    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<TopArticleListBean>
    ) {




//        callback.onResult(d,0,500)

    }
    //加载更多
    override fun loadRange(
        params: LoadRangeParams,
        callback: LoadRangeCallback<TopArticleListBean>
    ) {
//        TODO("Not yet implemented")
    }
}