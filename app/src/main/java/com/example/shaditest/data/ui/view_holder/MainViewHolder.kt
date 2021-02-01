package com.example.shaditest.data.ui.view_holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shaditest.data.ui.models.Results


abstract class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    abstract fun bindData(
        contex: Context,
        list: ArrayList<Results>,
        pos: Int,
        videos: Results
    )

}