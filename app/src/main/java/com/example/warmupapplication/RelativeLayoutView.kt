package com.example.warmupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_linear_layout.*

class RelativeLayoutView : AppCompatActivity() {
    private var status = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        //val textView: TextView = findViewById(R.id.statusText)
        //textView.text = getString( R.string.address_hint)

        statusBtn.setOnClickListener {
           // textView.text = getString(R.string.change_btn)
            statusText.setText(R.string.address_hint)
        }
    }
}