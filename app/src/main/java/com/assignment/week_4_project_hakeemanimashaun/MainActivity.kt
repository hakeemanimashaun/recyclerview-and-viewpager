package com.assignment.week_4_project_hakeemanimashaun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.navigation.NavigationBarItemView

class MainActivity : AppCompatActivity() {
    //creating fragment instances
    private val homeFragment = Home()
    private val peopleFragment = People()
    private val giftsFragment = Gifts()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setCurrentFragment(homeFragment)

        //each bottom navigation is set to its preferred fragment.
        var homeBottomNavView = findViewById<BottomNavigationItemView>(R.id.mi_home)
            homeBottomNavView.setOnClickListener{
                setCurrentFragment(homeFragment)
            }
        var peopleBottomNavView = findViewById<BottomNavigationItemView>(R.id.mi_people)
        peopleBottomNavView.setOnClickListener{
            setCurrentFragment(peopleFragment)
        }
        var giftsBottomNavView = findViewById<BottomNavigationItemView>(R.id.mi_gifts)
        giftsBottomNavView.setOnClickListener{
            setCurrentFragment(giftsFragment)
        }


    }
    // this function replaces the frame layout with selected fragment
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_fragment, fragment)
            commit()
        }

}

