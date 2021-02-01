package com.example.shaditest.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deevideos.data.local.preferences.PrefManager
import com.example.deevideos.data.local.room_db.DbBuilder
import com.example.deevideos.data.local.room_db.DbHelperImpl
import com.example.deevideos.ui.callbacks.ListItemClickListner
import com.example.deevideos.utils.Actions
import com.example.deevideos.utils.Status
import com.example.deevideos.utils.toasty
import com.example.shaditest.R
import com.example.shaditest.data.base.BaseViewModelFactory
import com.example.shaditest.data.remote.ApiClient
import com.example.shaditest.data.ui.models.Results
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListItemClickListner {
    lateinit var  viewModel:ShadiViewModel
    private lateinit var mAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initRecylerView()
        hitApi()
    }

    private fun hitApi() {
        viewModel.fetchUserList("10")
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            BaseViewModelFactory(
                ShadiRepo(
                    ApiClient,
                    DbHelperImpl(DbBuilder.getInstance(this)),
                    PrefManager
                )
            )
        ).get(ShadiViewModel::class.java)

        observeChanges()
    }

    private  fun observeChanges() {
        viewModel.getUserList().observe(this, Observer {
            when(it.status){
                Status.LOADING->{
                    progressBar.visibility =View.VISIBLE
                }
                Status.SUCCESS->{
                    progressBar.visibility =View.GONE
                    handleSuccesResult(it.data)
                }
                Status.ERROR->{
                    progressBar.visibility =View.GONE
                    toasty(this,it.message!!)
                }
            }
        })
   }

   inline private fun handleSuccesResult(data: List<Results>?) {
      mAdapter.addAllItem((data as ArrayList<Results>?)!!)
    }

    private fun initRecylerView() {
        val mlayoutManager = LinearLayoutManager(this)
        mAdapter = ListAdapter(this, this)
        recyclerView.apply {
            adapter = mAdapter
            layoutManager = mlayoutManager
            hasFixedSize()
        }

     }

    override fun onListItemClick(position: Int, type: String?, item: Any?) {
        when(type){
            Actions.TYPE_DECLINE->{
             viewModel.updateUser(item as Results)
            }
            Actions.TYPE_ACCEPT->{
                viewModel.updateUser(item as Results)
            }
        }
        mAdapter?.notifyItemChanged(position)

    }
}