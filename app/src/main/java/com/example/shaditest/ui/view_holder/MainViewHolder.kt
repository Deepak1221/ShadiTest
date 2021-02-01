package com.example.shaditest.ui.view_holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shaditest.data.local_db.entity.dbModels.User


abstract class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    abstract fun bindData(
            contex: Context,
            list: ArrayList<User>,
            pos: Int,
            user: User
    )

}