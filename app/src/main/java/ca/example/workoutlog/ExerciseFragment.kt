package ca.example.workoutlog

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.example.workoutlog.models.Exercise

class ExerciseFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    var myRecyclerViewAdapter: MyRecyclerViewAdapter? = null
    var listExercises : ArrayList<Exercise>? = null
    lateinit var v : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_exercise, container, false)
        myRecyclerViewAdapter = MyRecyclerViewAdapter(this@ExerciseFragment.listExercises!!)
        recyclerView = v.findViewById(R.id.exerciseRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@ExerciseFragment.context) as RecyclerView.LayoutManager?
        recyclerView.adapter = myRecyclerViewAdapter
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listExercises =  ArrayList()
        listExercises!!.add(Exercise("Bench Press"))
        listExercises!!.add(Exercise("Squats"))
    }
}
