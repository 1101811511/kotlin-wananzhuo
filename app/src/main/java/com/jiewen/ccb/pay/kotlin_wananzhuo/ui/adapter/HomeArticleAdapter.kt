package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.ItemHomeArticleBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/8  4:41 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeArticleAdapter(private val context: Context) :
    ListAdapter<TopArticleListBean, HomeArticleAdapter.HomeArticleViewHolder>(object :
        DiffUtil.ItemCallback<TopArticleListBean>() {
        //判断是否是同一个item
        override fun areItemsTheSame(
            oldItem: TopArticleListBean,
            newItem: TopArticleListBean
        ): Boolean {
            return oldItem == newItem
        }

        //如果item相同，此方法用于判断是否同一个 Item 的内容也相同
        override fun areContentsTheSame(
            oldItem: TopArticleListBean,
            newItem: TopArticleListBean
        ): Boolean {
            return oldItem == newItem
        }

    }) {

    lateinit var dataBinding: ItemHomeArticleBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home_article, parent, false)
        return HomeArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeArticleViewHolder, position: Int) {
        val topArticleListBean = currentList[position]
        holder.dataBinding.dataBean = topArticleListBean
    }


    inner class HomeArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dataBinding: ItemHomeArticleBinding = DataBindingUtil.bind(itemView)!!
    }

    /**
     * 重新加载必须建一个新的list
     */
    override fun submitList(list: List<TopArticleListBean>?) {
        super.submitList(if (list == null) mutableListOf() else
            mutableListOf<TopArticleListBean>().apply {
                addAll(
                    list
                )
            })
    }

}


