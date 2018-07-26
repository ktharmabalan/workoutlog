package ca.example.workoutlog.ui.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet


class CustomRecyclerView : RecyclerView {

//    private lateinit var recyclerView: RecyclerView;
    private val columnWidth: Int = -1

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {}
}
