package com.eshc.travelplatform.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<ITEM : Any, B : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    private val bindingVariableId: Int? = null
) : RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder<B>>() {
    val items = mutableListOf<ITEM>()

    // create
    fun replaceAll(items: List<ITEM>?) {
        items?.let {
            this.items.run {
                clear()
                addAll(it)
                notifyDataSetChanged()
            }
        }
    }

    // insert
    fun insertItems(items: List<ITEM>?, index: Int) {
        items?.let {
            this.items.addAll(index, items)
            notifyItemRangeInserted(index, items.size)
        }
    }

    fun insertItem(item: ITEM, index: Int) {
        items.run {
            add(index, item)
            notifyItemInserted(index)
        }
    }

    // update
    fun replaceItem(item: ITEM?, index: Int) {
        item?.let {
            this.items.run {
                this[index] = item
                notifyItemChanged(index)
            }
        }
    }

    // delete
    fun deleteItem(item: ITEM) {
        val index = items.indexOf(item)
        this.items.run {
            this.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    // delete by index
    fun deleteItem(index: Int) {
        if (index < items.size) {
            items.removeAt(index)
            //notifyItemRemoved(index)
        }
    }

    fun deleteItems(items: List<ITEM>?, index: Int) {
        this.items.run {
            this.removeAll(items as Collection<ITEM>)
            notifyItemRangeRemoved(index, items.size)
        }
    }

    fun changeItem(item: ITEM, index: Int) {
        if (index < items.size) {
            items[index] = item
            notifyItemChanged(index)
        }
    }

    fun getItem(position: Int) = items[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = object : ViewHolder<B>(
        layoutResId = layoutResId,
        parent = parent,
        bindingVariableId = bindingVariableId
    ) {}

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        holder.onBindViewHolder(items[position])
    }

    abstract class ViewHolder<B : ViewDataBinding>(
        @LayoutRes layoutResId: Int,
        parent: ViewGroup,
        private val bindingVariableId: Int?
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
    ) {
        var binding: B = DataBindingUtil.bind(itemView)!!

        fun onBindViewHolder(item: Any?) {
            try {
                bindingVariableId?.let {
                    binding.setVariable(it, item)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}