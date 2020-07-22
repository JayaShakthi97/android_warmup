package com.example.warmupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frame_btn.setOnClickListener {
            val intent = Intent(this, FrameLayoutView::class.java)
            startActivity(intent)
        }

        relative_btn.setOnClickListener {
            val intent = Intent(this, RelativeLayoutView::class.java)
            startActivity(intent)
        }

        linear_btn.setOnClickListener {
            val intent = Intent(this, LinearLayoutView::class.java)
            startActivity(intent)
        }

        recycle_btn.setOnClickListener {
            val intent = Intent(this, RecycleViewPage::class.java)
            startActivity(intent)
        }

        recycle_card_btn.setOnClickListener {
            val intent = Intent(this, RecyclerViewWithCards::class.java)
            startActivity(intent)
        }
    }
}