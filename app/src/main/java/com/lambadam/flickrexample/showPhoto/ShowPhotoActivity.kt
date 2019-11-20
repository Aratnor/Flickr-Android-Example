package com.lambadam.flickrexample.showPhoto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.bumptech.glide.Glide
import com.lambadam.flickrexample.R
import kotlinx.android.synthetic.main.activity_show_photo.*

class ShowPhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_photo)

        val photoUrl = intent.getStringExtra("photoUrl")
        Glide
            .with(this).load(photoUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background).into(imageView)
    }

}
