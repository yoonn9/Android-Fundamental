package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerview.databinding.ItemDisneyBinding
import com.example.recyclerview.model.Disney
import java.util.ArrayList

class DisneyAdapter(private val listDisney: ArrayList<Disney>) : RecyclerView.Adapter<DisneyAdapter.DisneyViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(data: Disney)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DisneyAdapter.DisneyViewHolder {
        val binding = ItemDisneyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DisneyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DisneyAdapter.DisneyViewHolder, position: Int) {
        holder.bind(listDisney[position])
    }

    override fun getItemCount(): Int {
        return listDisney.size
    }

    inner class DisneyViewHolder(private val binding: ItemDisneyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(disneyEntity: Disney) {
            with(binding){
                Glide.with(itemView.context)
                    .load(disneyEntity.image)
                    .apply(RequestOptions().override(55, 55))
                    .into(ivPoster)
                tvTitle.text = disneyEntity.title
                tvQuote.text = disneyEntity.quote
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(disneyEntity) }
            }
        }
    }
}