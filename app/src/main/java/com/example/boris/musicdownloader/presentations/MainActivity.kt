package com.example.boris.musicdownloader.presentations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.example.boris.musicdownloader.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val discoveryFragment: DiscoverFragment by lazy { DiscoverFragment() }
    private val songLibraryFragment: SongLibraryFragment by lazy { SongLibraryFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setOnNavigationItemSelectedListener(bottomNavViewListener)

        val fm = supportFragmentManager.beginTransaction()
        fm.apply {
            add(R.id.main_frame, discoveryFragment)
            addToBackStack(null)
            commit()
        }
    }

    private val bottomNavViewListener: (menuItem: MenuItem) -> Boolean = { menuItem ->
        val fm = supportFragmentManager.beginTransaction()
        when (menuItem.itemId) {
            R.id.discover_tab -> {
                Log.d(TAG, "discover tab pressed")
                fm.replace(R.id.main_frame, discoveryFragment)
                fm.commit()
            }
            R.id.song_library_tab -> {
                Log.d(TAG, "song library tab pressed")
                fm.replace(R.id.main_frame, songLibraryFragment)
                fm.commit()
            }
        }
        true
    }
}