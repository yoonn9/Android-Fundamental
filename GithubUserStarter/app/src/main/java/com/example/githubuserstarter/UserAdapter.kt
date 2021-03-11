package com.example.githubuserstarter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var userGithub = arrayListOf<User>()

    override fun getCount(): Int {
        return userGithub.size
    }

    override fun getItem(position: Int): Any {
        return userGithub[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView==null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val tvName: TextView = view.findViewById(R.id.nameMain)
        private val tvUsername: TextView = view.findViewById(R.id.usernameMain)
        private val tvCompany: TextView = view.findViewById(R.id.companyMain)
        private val tvLocation: TextView = view.findViewById(R.id.locationMain)
        private val ivAvatar: ImageView = view.findViewById(R.id.avatarMain)

        fun bind(user: User) {
            tvName.text = user.name
            tvUsername.text = user.username
            tvCompany.text = user.company
            tvLocation.text = user.location
            ivAvatar.setImageResource(user.avatar)
        }
    }
}