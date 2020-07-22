package com.example.warmupapplication

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val persons: List<Person>, val itemClickListener: PersonListItemListener) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(val list: View) : RecyclerView.ViewHolder(list) {
        val nameText: TextView = itemView.findViewById(R.id.person_name)
        val onlineBtn: Button = itemView.findViewById(R.id.online_btn)

        fun bind(position: Int, clickListener: PersonListItemListener){
            list.setOnClickListener {
                clickListener.onBtnClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val personView = inflater.inflate(R.layout.person_list_item, parent, false)

        return ViewHolder(personView)
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        val person: Person = persons[position]
        val textView = holder.nameText
        textView.text = person.name
        val button = holder.onlineBtn
        holder.bind(position, itemClickListener)
        button.text = if (person.online) "Online" else "Offline"
        if (person.online) button.setBackgroundColor(Color.parseColor("#0FF903"))
        else button.setBackgroundColor(Color.parseColor("#F91003"))
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    interface PersonListItemListener {
        fun onBtnClick(position: Int)
    }
}