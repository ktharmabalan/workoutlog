package ca.example.workoutlog.ui.MainViewPager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ca.example.workoutlog.MainActivity
import java.util.*


class ViewPagerAdapter(fm: FragmentManager, context: MainActivity) : FragmentPagerAdapter(fm) {
    private val fragmentList = ArrayList<Fragment>()
    private val titleList = ArrayList<String>()
    private val mainActivity : MainActivity = context

    init {
        addFragment(ExerciseTabFragment(), "Exercises")
        addFragment(SummaryTabFragment(), "Summary")
        addFragment(RoutineTabFragment(), "Routines")
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence = titleList[position]

    private fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }
}
