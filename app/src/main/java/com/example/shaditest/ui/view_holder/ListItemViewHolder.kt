package com.example.deevideos.ui.view_holder

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.example.deevideos.ui.callbacks.ListItemClickListner
import com.example.deevideos.utils.Actions
import com.example.deevideos.utils.loadImage
import com.example.shaditest.R
import com.example.shaditest.data.local_db.entity.dbModels.User
import com.example.shaditest.ui.view_holder.MainViewHolder
import kotlinx.android.synthetic.main.item_row_person.view.*


class ListItemViewHolder(val context: Context, itemView:View, val itemClickCallBack: ListItemClickListner) :
    MainViewHolder(itemView) {
    lateinit var mItem: User
    init {
        setListners()
    }


    override fun bindData(contex: Context,list: ArrayList<User>,position: Int,item: User) {
        mItem = item
        itemView.txtName.text = mItem.name?.first
        itemView.txtAge.text = "${mItem.dob?.age} years"
        itemView.txtAddress.text =   mItem.location?.city +" , "+ mItem.location?.state
        mItem.picture?.let {
            itemView.imgVideo.loadImage(it?.large)
        }
        if (mItem.action.equals(Actions.TYPE_DECLINE, true)) {
            itemView.groupAction.visibility = View.INVISIBLE
            itemView.txtActionMsg.visibility =View.VISIBLE
            itemView.txtActionMsg.setBackground(ContextCompat.getDrawable(context, R.drawable.decline_back_gradiant))
            itemView.txtActionMsg.text= "Member DECLINED"

        } else if (mItem.action.equals(Actions.TYPE_ACCEPT, true)) {
            itemView.groupAction.visibility = View.INVISIBLE
            itemView.txtActionMsg.visibility =View.VISIBLE
            itemView.txtActionMsg.setBackground(ContextCompat.getDrawable(context, R.drawable.accept_back_gradiant))
            itemView.txtActionMsg.text= "Member ACCEPTED"
        } else {
            itemView.txtActionMsg.visibility =View.GONE
            itemView.groupAction.visibility = View.VISIBLE

        }
    }
    private fun setListners() {
        itemView.btnDecline.setOnClickListener(this)
        itemView.btnAccept.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnDecline->{
                itemClickCallBack?.let {
                    mItem.action=Actions.TYPE_DECLINE
                    it.onListItemClick(adapterPosition ,Actions.TYPE_DECLINE,mItem)
                }
            }

            R.id.btnAccept->{
                itemClickCallBack?.let {
                    mItem.action=Actions.TYPE_ACCEPT
                    it.onListItemClick(adapterPosition ,Actions.TYPE_ACCEPT,mItem)
                }
            }
        }

    }
}