package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CharacterAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var character = arrayListOf<Character>()

    override fun getCount(): Int {
        return character.size
    }

    override fun getItem(position: Int): Any {
        return character[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView==null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_disney, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val char = getItem(position) as Character
        viewHolder.bind(char)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val tvTitle: TextView = view.findViewById(R.id.titleTv)
        private val tvQuote: TextView = view.findViewById(R.id.quote)
        private val ivImage: ImageView = view.findViewById(R.id.imgDisney)

        fun bind(character: Character) {
            tvTitle.text = character.title
            tvQuote.text = character.quote
            ivImage.setImageResource(character.image)
        }
    }
}