package com.lambadam.flickrexample.listPhotos

import androidx.core.view.ViewCompat.canScrollVertically
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


abstract class EndlessOnScrollListener(sglm: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    // use your LayoutManager instead
    private val llm: LinearLayoutManager = sglm
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (!recyclerView.canScrollVertically(1)) {
            onScrolledToEnd()
        }
    }

    abstract fun onScrolledToEnd()

    companion object {

        var TAG = EndlessOnScrollListener::class.java.simpleName
    }
}