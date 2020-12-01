package com.example.wheretoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = RestaurantListFragment()
        val profileFragment = ProfileScreenFragment()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, listFragment)
            commit()
        }


        findViewById<Button>(R.id.btn_fragment1).setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, listFragment)
                addToBackStack(null)
                commit()
            }
        }


        findViewById<Button>(R.id.btn_fragment2).setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, profileFragment)
                addToBackStack(null)
                commit()
            }
        }


    }


}