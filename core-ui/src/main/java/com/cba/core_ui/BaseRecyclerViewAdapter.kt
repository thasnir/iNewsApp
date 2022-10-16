package com.cba.core_ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : ViewDataBinding , E> :
       RecyclerView.Adapter<BaseRecyclerViewAdapter<T,E>.BaseVh>()
{

    private val itemList = ArrayList<E>()
    var onItemClick:((E,Int) -> Unit)?=null

    abstract  fun getView(inflater: LayoutInflater,parent: ViewGroup,viewType: Int) : T

    abstract  fun bind(binding: T,item : E,position: Int)

    fun updateItems(items : List<E>){
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }
    fun notifyChanges(){
        notifyItemRangeChanged(0,itemList.size, arrayOf("partial_data_change"))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVh {
       val inflater =LayoutInflater.from(parent.context)
        return  BaseVh(getView(inflater,parent,viewType))
    }

    override fun onBindViewHolder(holder: BaseVh, position: Int) {
        val binding = holder.binding
        val item =itemList[position]
        binding.root.setOnClickListener { onItemClick?.invoke(item,position) }
        bind(binding,item,position)
    }

    override fun getItemCount() =itemList.size

    override fun onBindViewHolder(holder: BaseVh, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.binding.executePendingBindings()
    }
    inner  class  BaseVh(val binding: T):RecyclerView.ViewHolder(binding.root)

}