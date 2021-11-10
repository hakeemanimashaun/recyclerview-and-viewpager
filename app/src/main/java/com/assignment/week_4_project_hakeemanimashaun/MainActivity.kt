package com.assignment.week_4_project_hakeemanimashaun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.navigation.NavigationBarItemView

class MainActivity : AppCompatActivity() {
    val homeFragment = Home()
    val peopleFragment = People()
    val giftsFragment = Gifts()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setCurrentFragment(homeFragment)

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
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }

}

