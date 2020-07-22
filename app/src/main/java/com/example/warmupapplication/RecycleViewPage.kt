package com.example.warmupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewPage : AppCompatActivity() {
    private lateinit var personList: ArrayList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        personList = Person.createPersonList(10)

        val listener = object : PersonAdapter.PersonListItemListener{
            override fun onBtnClick(position: Int) {
                Log.i("recycle item", position.toString())
            }
        }

        val adapter = PersonAdapter(personList, listener)
        rvPersons.adapter = adapter
        rvPersons.layoutManager = LinearLayoutManager(this)

        add_person_btn.setOnClickListener {
            val preCount = adapter.itemCount
            personList.add(0, Person("New Person $preCount", 12, false))
            Log.i("recycle", "New data added")

            adapter.notifyItemInserted(0);
            rvPersons.scrollToPosition(0);
        }
    }
}
