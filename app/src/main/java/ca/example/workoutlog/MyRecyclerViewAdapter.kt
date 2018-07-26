package ca.example.workoutlog

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ca.example.workoutlog.models.Exercise


class MyRecyclerViewAdapter(var exercises: List<Exercise>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        Log.w("MyRecyclerViewAdapter", "onCreateViewHolder")
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_exercise, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val exercise = exercises[position]
        holder?.textView?.text = exercise.name
        holder?.containerObj!!.setOnClickListener {
            Log.w("MyRecyclerViewAdapter", "Item clicked at ${position} ${holder.textView.text}")
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView
        var containerObj : ConstraintLayout

        init {
            textView = itemView.findViewById(R.id.exerciseName)
            containerObj = itemView.findViewById(R.id.exerciseObj)
        }
    }
}
