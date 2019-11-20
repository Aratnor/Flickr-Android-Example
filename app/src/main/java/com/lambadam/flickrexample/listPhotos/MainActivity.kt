package com.lambadam.flickrexample.listPhotos

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambadam.domain.model.photoModels.Photo
import com.lambadam.flickrexample.R
import com.lambadam.flickrexample.ViewModelFactory
import com.lambadam.flickrexample.listPhotos.ListPhotosAdapter.OnItemClickListener
import com.lambadam.flickrexample.showPhoto.ShowPhotoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mLinearLayoutManager = LinearLayoutManager(this)

    private val mAdapter = ListPhotosAdapter(this, emptyList(),object :
        OnItemClickListener {
        override fun onItemClick(photo: Photo,photoUrl: String) {
            startShowIntent(photo,photoUrl)
        }
    })

    private val viewModel: ListPhotosViewModel by lazy {
        ViewModelProviders
            .of(this, ViewModelFactory.getInstance(application))
            .get(ListPhotosViewModel::class.java)
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
        setInitPhotos()
    }
    private fun setInitPhotos() {
        if(!isNetworkAvailable()){
            showNetworkConAlertDialog("You need internet connection for use this app")
        } else viewModel.updateAllPhotos()
    }

    private fun startShowIntent(photo: Photo,photoUrl: String) {
        // TODO: If need another info from photo object can be passed here as bundle
        val intent = Intent(this,ShowPhotoActivity::class.java)
        intent.putExtra("photoUrl",photoUrl)
        startActivity(intent)
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = mLinearLayoutManager
        recyclerView.adapter = mAdapter
    }

    private fun setRecyclerViewScrollListener() {
        var loading = false
        recyclerView.addOnScrollListener(object : EndlessOnScrollListener(mLinearLayoutManager) {
            override fun onScrolledToEnd() {
                if(!loading){
                    loading = true
                    viewModel.updateAllPhotos()
                }
                loading = false
            }

        })
    }
    private fun showNetworkConAlertDialog(message: String) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Warning Connection!")
        builder.setMessage(message)
        builder.show()

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.isDefaultNetworkActive
    }


}
