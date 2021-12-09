//package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.paging.PagedListAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.jiewen.ccb.pay.kotlin_wananzhuo.R
//import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.ItemHomeArticleBinding
//import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean
//
///**
// *    author : 桶哥二号
// *    motto : Anything is possible
// *    date   : 2021/12/8  10:12 上午
// *    desc   : 我好难呀，我太难了呀
// *    version: 1.0
// */
//class TopArticleAdapter(val context: Context) :
//    PagedListAdapter<TopArticleListBean, TopArticleAdapter.TopArticleViewHolder>(diffCallBack) {
//    lateinit var dataBinding: ItemHomeArticleBinding
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopArticleViewHolder {
//        dataBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(context),
//            R.layout.item_home_article,
//            parent,
//            false
//        )
//        return TopArticleViewHolder(dataBinding.root)
//    }
//
//    override fun onBindViewHolder(holder: TopArticleViewHolder, position: Int) {
//        dataBinding.dataBean = getItem(position)
//
//    }
//
//    inner class TopArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//
//    companion object {
//        // DiffUtil用来辅助re的 相关链接 https://www.jianshu.com/p/8514d5c0ee60
//        val diffCallBack = object : DiffUtil.ItemCallback<TopArticleListBean>() {
//            //判断是否是同一个item
//            override fun areItemsTheSame(
//                oldItem: TopArticleListBean,
//                newItem: TopArticleListBean
//            ): Boolean {
//                return oldItem.courseId == newItem.courseId
//            }
//
//            //如果item相同，此方法用于判断是否同一个 Item 的内容也相同
//            override fun areContentsTheSame(
//                oldItem: TopArticleListBean,
//                newItem: TopArticleListBean
//            ): Boolean {
//                return oldItem == newItem
//            }
//
//        }
//    }
//
//
//}
//
