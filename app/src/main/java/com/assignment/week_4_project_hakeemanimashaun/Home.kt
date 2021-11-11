package com.assignment.week_4_project_hakeemanimashaun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class Home: Fragment(R.layout.home) {
    lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


         // inflate the layout for this fragment
        val view=inflater!!.inflate(R.layout.home, container, false)
        val images = listOf<Int>(
            R.drawable.vector,
            R.drawable.backgroundone,
            R.drawable.middleweather,
            R.drawable.backgroundtwo
        )
        //instance of adapter
        val adapter = ViewPagerAdapter(images)
        //setting adapter to own viewpager adapter and design details
        view.findViewById<ViewPager2>(R.id.view_pager).adapter = adapter

        viewPager = view.findViewById(R.id.view_pager)
        viewPager.setPadding(80, 20, 80, 20,)
        viewPager.adapter = ViewPagerAdapter(images)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

        //transforming view pager display style and transition
        val compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager.setPageTransformer(compositePageTransformer)

        //recyclerview and recyclerview contents
        val arrayList = ArrayList<RecyclerViewModel>()
        arrayList.add(
            RecyclerViewModel("Fatima","30-12-2034",
            "42 days left", R.drawable.contactfour))
        arrayList.add(RecyclerViewModel("Ola machiavelli","23-2-2035",
            "56 days left", R.drawable.contact))
        arrayList.add(RecyclerViewModel("Hakeem","25-4-2035",
            "82 days left", R.drawable.contacttwo))
        arrayList.add(RecyclerViewModel("Keena","30-6-2035",
            "107 days left", R.drawable.contactthree))
        val recyclerAdapter = RecyclerViewAdapter(arrayList, this)

        //recycler view layout and adapter
        view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(this.context)
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = recyclerAdapter


        return view





    }

}