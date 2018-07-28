package ca.example.workoutlog.ui.MainViewPager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.example.workoutlog.R
import ca.example.workoutlog.models.Exercise
import kotlinx.android.synthetic.main.activity_main.*

class ExerciseTabFragment : Fragment(), MyRecyclerViewAdapter.MyClickListener {

    private var EXTRA_MESSAGE = "ExerciseTabFragment"

    private lateinit var recyclerView: RecyclerView
    private lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var v : View
    private var listExercises : ArrayList<Exercise> = ArrayList()
    private var selectedExercises : ArrayList<Int> = ArrayList()

    init {
        listExercises.add(Exercise("Bench Press"))
        listExercises.add(Exercise("Squats"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_exercise, container, false)

        myRecyclerViewAdapter = MyRecyclerViewAdapter(this@ExerciseTabFragment.listExercises)
        myRecyclerViewAdapter.setClickListener(myClickListener = this)
        myRecyclerViewAdapter.setLongClickListener(myLongClickListener = this)

        viewManager = LinearLayoutManager(this@ExerciseTabFragment.context)
        recyclerView = v.findViewById<RecyclerView>(R.id.exerciseRecyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = myRecyclerViewAdapter
        }

        return v
    }

    override fun onItemClick(position: Int) {
        val exercise = listExercises[position]
        exercise.isSelected = true
        listExercises[position] = exercise
        if (exercise.isSelected && !selectedExercises.contains(position)) {
            selectedExercises.add(position)
        } else {
            selectedExercises.remove(position)
        }
        if (selectedExercises.size > 0) {
            activity.toolbar_title.text = "${selectedExercises.size} Item(s) selected"
        } else {
            activity.toolbar_title.text = getString(R.string.app_name)
        }
//        Toast.makeText(activity, "Item clicked at $position ${listExercises[position].name}", Toast.LENGTH_SHORT).show()
//        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
//        }
//        startActivity(intent)
    }

    override fun onItemLongClick(position: Int) {
        val exercise = listExercises[position]
        exercise.isSelected = !exercise.isSelected
        listExercises[position] = exercise
        if (exercise.isSelected && !selectedExercises.contains(position)) {
            selectedExercises.add(position)
        } else {
            selectedExercises.remove(position)
        }
        if (selectedExercises.size > 0) {
            activity.toolbar_title.text = "${selectedExercises.size} Item(s) selected"
        } else {
            activity.toolbar_title.text = getString(R.string.app_name)
        }
//        Toast.makeText(activity, "Item long clicked at $position ${listExercises[position].name}", Toast.LENGTH_SHORT).show()
    }
}
