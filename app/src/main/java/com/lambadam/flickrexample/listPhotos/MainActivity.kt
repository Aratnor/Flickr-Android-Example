package com.lambadam.flickrexample.listPhotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambadam.flickrexample.R
import com.lambadam.flickrexample.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mLinearLayoutManager = LinearLayoutManager(this)

    private val mAdapter = ListPhotosAdapter(this, emptyList())

    private val viewModel: ListPhotosViewModel by lazy {
        ViewModelProviders
            .of(this, ViewModelFactory.getInstance(application))
            .get(ListPhotosViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.updateAllPhotos()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        setRecyclerViewScrollListener()
        viewModel.photos.observe(this, Observer {
            mAdapter.updatePhotos(it!!)
            mAdapter.notifyDataSetChanged()
        })
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = mLinearLayoutManager
        recyclerView.adapter = mAdapter
    }

    private fun setRecyclerViewScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(!recyclerView.canScrollVertically(1) && dy != 0)
                {
                    viewModel.updateAllPhotos()
                    mAdapter.notifyDataSetChanged()
                }
            }
        })
    }


}
