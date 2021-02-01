package com.example.shaditest.data.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deevideos.ui.callbacks.ListItemClickListner
import com.example.deevideos.ui.view_holder.ListItemViewHolder
import com.example.shaditest.R
import com.example.shaditest.data.ui.models.Results
import com.example.shaditest.data.ui.view_holder.MainViewHolder

class ListAdapter(val context:Context, val callback: ListItemClickListner):
    RecyclerView.Adapter<MainViewHolder>() {
    var mList: ArrayList<Results>
    var layoutInflater: LayoutInflater
    private var isLoadingAdded: Boolean = false
    private var retryPageLoad: Boolean = false

    init {
          mList = ArrayList()
          layoutInflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var viewHolder: MainViewHolder? = null
        val viewGroup = layoutInflater.inflate(R.layout.item_row_person, parent, false)
        viewHolder = ListItemViewHolder(context, viewGroup, callback)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return  if(mList!=null) mList.size else 0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bindData(context,mList,position,mList[position])
    }

//    override fun getItemViewType(position: Int): Int {
//      return
//
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return View1ViewHolder(
//            LayoutInflater.from(context).inflate(R.layout.item_video, parent, false)
//        )
//
//    }
//
//    override fun getItemCount(): Int {
//      return  mList.size
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
////        if (list[position].viewType === VIEW_TYPE_ONE) {
////
////        }
//        (holder as View1ViewHolder).bind(position,mList[position])
//    }
//
//
//
//    private inner class View1ViewHolder(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//        fun bind(position: Int, item: Results) {
//           itemView.txtTitle.text = item.vid_title
//            item.player_content?.let { itemView.imgVideo.loadImage(it.prepareImageUrl()) }
//        }
//        init {
//            clickListners()
//        }
//
//        fun clickListners(){
//            itemView.setOnClickListener {
//                val intent = Intent(context, VideoPlayerActivity::class.java)
//                context.startActivity(intent)
//            }
//        }
//    }

    fun addAllItem(list: ArrayList<Results>) {
        isLoadingAdded = false
        mList = list
        notifyDataSetChanged()

    }

    fun addItemAtListEnd(list: ArrayList<Results>) {
        for (result in list) {
            add(result)
        }

    }

    fun add(r: Results) {
        mList.add(r)
        notifyItemInserted(mList.size - 1)

    }

    fun addLoadingFooter() {
        isLoadingAdded = true
       // add(Results(null, null, null, null, null))
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false
        val pos = mList.size - 1
        val result = getItem(pos)
        if(result!=null){
            mList.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    private fun getItem(pos: Int): Results {
        return mList.get(pos)

    }
}