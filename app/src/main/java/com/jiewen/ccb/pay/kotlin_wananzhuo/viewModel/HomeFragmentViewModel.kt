package com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.ItemKeyedDataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jiewen.ccb.pay.kotlin_wananzhuo.Config
import com.jiewen.ccb.pay.kotlin_wananzhuo.Repository.HomeRepository
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.BannerBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/7  8:35 上午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeFragmentViewModel : ViewModel() {


//    var mDataSource: DataSource<Int, TopArticleListBean>? = null

    val bannerData: MutableLiveData<ArrayList<BannerBean>> = MutableLiveData()

    var mPageData: MutableLiveData<ArrayList<TopArticleListBean>> = MutableLiveData()

    //使用paging 2失败。。没有和协程结合起来。。。
//    val mFactory = object : DataSource.Factory<Int, TopArticleListBean>() {
//        override fun create(): DataSource<Int, TopArticleListBean> {
//            if (mDataSource == null || mDataSource!!.isInvalid()) {
//                mDataSource = creatDateSource()
//            }
//            return mDataSource!!
//        }
//
//    }
//
//    fun getPageData(): LiveData<PagedList<TopArticleListBean>> {
//        if (null == mPageData) {
//            val config = PagedList.Config.Builder()
//                .setPageSize(20) //分页大小
//                .setInitialLoadSizeHint(20) //首次加载大小
//                .setPrefetchDistance(10) //预加载距离：还剩10个就要滑到底了，就进行预加载
//                .build()
//            mPageData = LivePagedListBuilder(mFactory, config).build()
//        }
//        return mPageData!!
//    }
//
//
//    fun creatDateSource(): DataSource<Int, TopArticleListBean> {
//        return object : ItemKeyedDataSource<Int, TopArticleListBean>() {
//            override fun getKey(item: TopArticleListBean): Int {
//                return item.courseId.toInt()
//            }
//
//            //首次加载
//            override fun loadInitial(
//                params: LoadInitialParams<Int>,
//                callback: LoadInitialCallback<TopArticleListBean>
//            ) {
//                callback.onResult()
//            }
//
//            //加载更多
//            override fun loadAfter(
//                params: LoadParams<Int>,
//                callback: LoadCallback<TopArticleListBean>
//            ) {
//                TODO("Not yet implemented")
//            }
//
//            //加载之前的，不知道有啥用呀
//            override fun loadBefore(
//                params: LoadParams<Int>,
//                callback: LoadCallback<TopArticleListBean>
//            ) {
//            }
//
//
//        }
//    }

    private val homeRepository by lazy {
        HomeRepository()
    }


    //请求banner接口
    fun getBanner() {
        viewModelScope.launch {
            runCatching {
                bannerData.value = homeRepository.requestBanner()
            }.isSuccess
        }
    }

    //请求首页置顶的文章
    fun getTopArticleList() {
        viewModelScope.launch {
            val resutlt = kotlin.runCatching {
                val toallArticle = ArrayList<TopArticleListBean>()
                val topArticle = viewModelScope.async {
                    homeRepository.requestArticleList()
                }
                val homeFirstArticle = viewModelScope.async {
                    homeRepository.requestHomeArticleList()
                }

                toallArticle.addAll(topArticle.await())
                toallArticle.addAll(homeFirstArticle.await().datas)
                mPageData.value = toallArticle

            }.isFailure


            Log.i(Config.TAG, resutlt.toString())

        }
    }
}