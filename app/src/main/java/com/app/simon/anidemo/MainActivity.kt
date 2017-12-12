package com.app.simon.anidemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add_first.setOnClickListener {
            val itemView = ItemView(this).setData("这是标题")
            linear_layout.addItemAtFirst(itemView)
        }
        button_add_last.setOnClickListener {
            val itemView = ItemView(this).setData("这是标题")
            linear_layout.addItemAtLast(itemView)
        }

        button_remove_first.setOnClickListener {
            linear_layout.removeViewAt(0)
        }
        button_remove_last.setOnClickListener {
            linear_layout.removeViewAt(linear_layout.childCount - 1)
        }

    }
}
