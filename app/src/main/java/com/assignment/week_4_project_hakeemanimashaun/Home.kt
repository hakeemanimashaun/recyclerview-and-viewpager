package com.assignment.week_4_project_hakeemanimashaun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class Home: Fragment(R.layout.home) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view=inflater!!.inflate(R.layout.home, container, false)
        val images = listOf<Int>(
            R.drawable.vector,
            R.drawable.backgroundone,
            R.drawable.middleweather,
            R.drawable.backgroundtwo
        )
        val adapter = ViewPagerAdapter(images)
        view.findViewById<ViewPager2>(R.id.view_pager).adapter = adapter


        /*view.findViewById<ViewPager2>(R.id.view_pager).setPageTransformer(ViewPager2.PageTransformer(){
            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer().addTransformer(MarginPageTransformer(40))
            compositePageTransformer.addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
        })*/

        /*val compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)pbcopy < ~/.ssh/id_ed25519.pub
            page.scaleY = 0.85f + r * 0.15f
        }
        view.findViewById<ViewPager2>(R.id.view_pager).setPageTransformer(compositePageTransformer)*/


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
        view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(this.context)
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = recyclerAdapter

        // Inflate the layout for this fragment

        return view





    }

}