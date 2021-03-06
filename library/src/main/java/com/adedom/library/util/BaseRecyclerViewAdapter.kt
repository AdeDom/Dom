package com.adedom.library.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<E>(
    private val resource: () -> Int,
    private val bindView: (holder: BaseRecyclerViewAdapter<E>.BaseHolder, position: Int, items: ArrayList<E>) -> Unit
) : RecyclerView.Adapter<BaseRecyclerViewAdapter<E>.BaseHolder>() {

    private var items = ArrayList<E>()
    var onItemClick: ((E) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder =
        BaseHolder(
            LayoutInflater.from(parent.context)
                .inflate(resource.invoke(), parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseHolder, position: Int) =
        bindView.invoke(holder, position, items)

    fun setList(items: List<E>) {
        this.items = items as ArrayList<E>
        notifyDataSetChanged()
    }

    inner class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}