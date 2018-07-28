package ca.example.workoutlog.ui.MainViewPager

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ca.example.workoutlog.R
import ca.example.workoutlog.models.Exercise


class MyRecyclerViewAdapter(var exercises: List<Exercise>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    private var myClickListener: MyClickListener? = null
    private var myLongClickListener: MyClickListener? = null
//    private var idxClicked: Int = -1
//    private var idxLongClicked: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        Log.i("MyRecyclerViewAdapter", "onCreateViewHolder")
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_exercise, parent, false)
        return MyViewHolder(v)
    }

    interface MyClickListener {
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }

    fun setClickListener(myClickListener: MyClickListener) {
        this.myClickListener = myClickListener
    }

    fun setLongClickListener(myLongClickListener: MyClickListener) {
        this.myLongClickListener = myLongClickListener
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val exercise = exercises[position]
        holder?.textView?.text = exercise.name
        holder?.cardView?.setOnClickListener {
            run {
//                idxClicked = position
                myClickListener?.onItemClick(position)
                notifyDataSetChanged()
            }
        }

        holder?.cardView?.setOnLongClickListener {
            run {
                //            idxLongClicked = position
                myLongClickListener?.onItemLongClick(position)
                notifyDataSetChanged()
                false
            }
        }

//      || idxClicked == position
        if (exercises[position].isSelected) {
            holder?.cardView?.setCardBackgroundColor(Color.parseColor("#e6e6e6"))
        } else {
            holder?.cardView?.setCardBackgroundColor(Color.WHITE)
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView = itemView.findViewById(R.id.exerciseName)
        var cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}
