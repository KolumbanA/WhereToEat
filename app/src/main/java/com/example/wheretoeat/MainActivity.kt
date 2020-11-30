package com.example.wheretoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretoeat.adapter.MyAdapter
import com.example.wheretoeat.repository.Repository

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = Restaurant_list_fragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, listFragment)
            commit()
        }

        /*
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful) {
                Log.d("response", response.body()?.name.toString())
            }
            else
            {
                Log.d("response", response.errorBody().toString())
            }
        })
        */
    }


}