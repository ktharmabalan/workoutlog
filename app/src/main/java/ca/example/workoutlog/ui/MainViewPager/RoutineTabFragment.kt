package ca.example.workoutlog.ui.MainViewPager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ca.example.workoutlog.R

class RoutineTabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Toast.makeText(activity,  "Routine Tab", Toast.LENGTH_SHORT).show()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine, container, false)
    }
}
