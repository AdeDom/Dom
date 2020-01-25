package com.adedom.library.extension

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

//mSwipeRefreshLayout.setSwipeRefresh { fetchPlayers() }
fun SwipeRefreshLayout.setSwipeRefresh(refresh: () -> Unit) {
    this.apply {
        setColorSchemeResources(
            android.R.color.holo_red_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_green_light,
            android.R.color.holo_blue_light
        )
        setOnRefreshListener { refresh.invoke() }
    }
}
