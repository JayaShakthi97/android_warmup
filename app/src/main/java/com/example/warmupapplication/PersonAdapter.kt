package com.example.warmupapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(
    private val persons: List<Person>,
    private val itemClickListener: PersonListItemListener
) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(list: View) :
        RecyclerView.ViewHolder(list) {
        private val nameText: TextView = itemView.findViewById(R.id.person_name)
        private val onlineBtn: Button = itemView.findViewById(R.id.online_btn)

        fun bind(item: Person, action: PersonListItemListener) {
            nameText.text = item.name
            onlineBtn.text = if (item.online) "Online" else "Offline"
            if (item.online) onlineBtn.setBackgroundColor(Color.parseColor("#0FF903"))
            else onlineBtn.setBackgroundColor(Color.parseColor("#F91003"))
            onlineBtn.setOnClickListener {
                action.onBtnClick(adapterPosition)
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
        holder.bind(person, itemClickListener)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    interface PersonListItemListener {
        fun onBtnClick(position: Int)
    }
}