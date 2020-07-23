package com.example.warmupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewPage : AppCompatActivity(), PersonAdapter.PersonListItemListener {
    private lateinit var personList: ArrayList<Person>
    private lateinit var adapter : PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        personList = Person.createPersonList(20)

        adapter = PersonAdapter(personList, this)
        rvPersons.adapter = adapter
        rvPersons.layoutManager = LinearLayoutManager(this)

        add_person_btn.setOnClickListener {
            val preCount = adapter.itemCount
            personList.add(0, Person("New Person $preCount", 12, false))
            Log.i("recycle", "New data added")

            adapter.notifyItemInserted(0)
            rvPersons.scrollToPosition(0)
        }
    }

    override fun onBtnClick(position: Int) {
        personList[position].online = !personList[position].online
        adapter.notifyItemChanged(position)
    }
}
