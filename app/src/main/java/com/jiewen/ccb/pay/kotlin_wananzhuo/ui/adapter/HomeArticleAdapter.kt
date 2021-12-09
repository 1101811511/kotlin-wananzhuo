package com.jiewen.ccb.pay.kotlin_wananzhuo.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jiewen.ccb.pay.kotlin_wananzhuo.R
import com.jiewen.ccb.pay.kotlin_wananzhuo.databinding.ItemHomeArticleBinding
import com.jiewen.ccb.pay.kotlin_wananzhuo.entity.TopArticleListBean
import com.jiewen.ccb.pay.kotlin_wananzhuo.viewModel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.item_home_article.view.*

/**
 *    author : 桶哥二号
 *    motto : Anything is possible
 *    date   : 2021/12/8  4:41 下午
 *    desc   : 我好难呀，我太难了呀
 *    version: 1.0
 */
class HomeArticleAdapter(val context: Context)  :RecyclerView.Adapter<HomeArticleAdapter.HomeArticleViewHolder>(){

    lateinit var dataBinding: ItemHomeArticleBinding
    val dataList:ArrayList<TopArticleListBean>  = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeArticleViewHolder {
         val view =LayoutInflater.from(context).inflate(R.layout.item_home_article,parent,false)

        return HomeArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeArticleViewHolder, position: Int) {
        val topArticleListBean = dataList[position]
        holder.dataBinding.dataBean = topArticleListBean

    }


    @SuppressLint("NotifyDataSetChanged")
    fun  setData(list:java.util.ArrayList<TopArticleListBean>){
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int  = dataList.size


    inner  class HomeArticleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val dataBinding:ItemHomeArticleBinding = DataBindingUtil.bind(itemView)!!
//        val   databinds:ItemHomeArticleBinding = dataBind
    }
}