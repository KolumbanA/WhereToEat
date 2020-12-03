package com.example.wheretoeat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.adapter.MyAdapter
import com.example.wheretoeat.repository.Repository


class RestaurantListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_restaurant_recycler_view)
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        //kereses get request

        val options: MutableMap<String,String> = mutableMapOf()

        view.findViewById<Button>(R.id.search_button).setOnClickListener{
            options["name"] = view.findViewById<EditText>(R.id.et_name_search).text.toString()
            options["city"] = view.findViewById<EditText>(R.id.et_city_search).text.toString()

            viewModel.getRestaurantsDetailed(options)
            viewModel.myResponseRestaurantsDetailed.observe(this, Observer{ response ->
                if(response.isSuccessful){
                    response.body()?.let { myAdapter.setData( it.restaurants ) }
                    //Log.d("rest", response.body()?.restaurants!!.size.toString())
                }
                else{
                    Log.d("rest", response.code().toString())
                    //Toast.makeText(context, response.code().toString(), Toast.LENGTH_SHORT).show()
                }
            })
        }


        //------







    }

    private fun setupRecyclerview(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

}