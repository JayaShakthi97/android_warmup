package com.example.warmupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_linear_layout.*

class LinearLayoutView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        var status = 0;

        statusBtn.setOnClickListener {
            if (status == 0){
                statusText.text = getString(R.string.married)
                status = 1
            }else{
                statusText.text = getString(R.string.single)
                status = 0;
            }
        }
    }
}