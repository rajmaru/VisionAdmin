package com.one.visionadmin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.one.visionadmin.databinding.MovieItemBinding
import com.one.visionadmin.databinding.UsersItemBinding
import com.one.visionadmin.models.Movie
import com.one.visionadmin.models.User

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private lateinit var usersList: ArrayList<User>
    private lateinit var context: Context
    var onItemClick: ((User) -> Unit)? = null

    fun setUserList(context: Context, usersList: ArrayList<User>){
        this.usersList = usersList
        this.context = context
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(UsersItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = usersList[position]
        if(user.img != null){
            Glide.with(context)
                .load(user.img)
                .into(holder.binding.userImg)
        }
        holder.binding.userName.text = user.name
        holder.binding.userEmail.text = user.email
        holder.binding.userPlan.text = "Plan : ${user.plan}"
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(user)
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    inner class UsersViewHolder(val binding: UsersItemBinding): RecyclerView.ViewHolder(binding.root)
}