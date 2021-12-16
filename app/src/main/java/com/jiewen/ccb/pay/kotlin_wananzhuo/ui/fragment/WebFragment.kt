package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.fragment

import android.annotation.SuppressLint
import android.view.View
import android.webkit.*
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.base.BaseFragment
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.FragmentWebBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.WebFragmentViewHolder

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/10  4:30 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class WebFragment :
    BaseFragment<FragmentWebBinding, WebFragmentViewHolder>(WebFragmentViewHolder::class.java) {

    override fun getLayoutId(): Int = R.layout.fragment_web

    override fun initView() {
        initWebView()
        databing.floatingBtton.setOnClickListener {
            //判断h5页面是否返回到原始界面
            if (databing.webView.canGoBack()){
                databing.webView.goBack()
            }else{
                naback()
//                showActivityBottom()
            }

        }
    }




   @SuppressLint("SetJavaScriptEnabled")
   fun  initWebView()  {
     val  dataBean =  arguments?.getSerializable("item") as TopArticleListBean
        val webSettings: WebSettings = databing.webView.settings
        webSettings.javaScriptEnabled = true
       databing.webView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
       databing.webView.settings.loadWithOverviewMode = true

        //如果不设置WebViewClient，请求会跳转系统浏览器
       databing.webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址）
                //均交给webView自己处理，这也是此方法的默认处理
                return false
            }

            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址）
                //均交给webView自己处理，这也是此方法的默认处理
                return false
            }
        }

       databing.webView.loadUrl(dataBean.link)

        //webView加载成功回调
       databing.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                //进度小于100，显示进度条
                if (newProgress<100){
                    databing.progressBar.visibility = View.VISIBLE
                }
                //等于100隐藏
                else if (newProgress==100){
                    databing.progressBar.visibility = View.GONE
                }
                //改变进度
                databing.progressBar.progress = newProgress
            }
        }
    }


}