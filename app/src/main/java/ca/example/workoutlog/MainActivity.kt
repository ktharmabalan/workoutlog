package ca.example.workoutlog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import ca.example.workoutlog.ui.MainViewPager.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "test"
    private lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        title = toolbar.findViewById(R.id.toolbar_title)

        view_pager.adapter = ViewPagerAdapter(supportFragmentManager, this@MainActivity)
        tab_layout.setupWithViewPager(view_pager)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

/*    override fun onStart() {
        super.onStart()
        Log.w(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG, "onResumed")
    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(TAG, "onDestroy")
    }*/
}
