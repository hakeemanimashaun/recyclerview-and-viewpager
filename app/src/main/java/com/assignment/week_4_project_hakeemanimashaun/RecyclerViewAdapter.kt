package com.assignment.week_4_project_hakeemanimashaun

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val arraylist: ArrayList<RecyclerViewModel>, val context: Home)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(recyclerViewModel: RecyclerViewModel){
            itemView.findViewById<ImageView>(R.id.notification_profile)
                .setImageResource(recyclerViewModel.images)
            itemView.findViewById<TextView>(R.id.notification_name).text = recyclerViewModel.name
            itemView.findViewById<TextView>(R.id.notification_days_left)
                .text = recyclerViewModel.daysLeft
            itemView.findViewById<TextView>(R.id.notification_due_date)
                .text = recyclerViewModel.dueDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.birthday_reminder,parent,false)
            return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arraylist[position])

    }

    override fun getItemCount(): Int {
            return arraylist.size
    }

}