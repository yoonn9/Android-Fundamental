package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerview.databinding.ItemListBinding
import com.example.recyclerview.model.Character
import java.util.ArrayList

class ListCharAdapter(private val listChar: ArrayList<Character>) : RecyclerView.Adapter<ListCharAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCharAdapter.ListViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListCharAdapter.ListViewHolder, position: Int) {
        holder.bind(listChar[position])
    }

    override fun getItemCount(): Int {
        return listChar.size
    }

    inner class ListViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(char: Character) {
            with(binding){
                Glide.with(itemView.context)
                    .load(char.image)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgDisney)

                titleTv.text = char.title
                quote.text = char.quote

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(char) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Character)
    }
}