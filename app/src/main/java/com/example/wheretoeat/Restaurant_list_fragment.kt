package com.example.wheretoeat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Restaurant_list_fragment : Fragment() {
    private var namesList = mutableListOf<String>()
    private var descriptionList = mutableListOf<String>()
    private var phoneList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // view.findViewById<RecyclerView>(R.id.rv_restaurant_recycler_view)

        //postToList()

    }

    private fun addToList(name: String, description: String, phonenumber: String, image: Int)
    {
        namesList.add(name)
        descriptionList.add(description)
        phoneList.add(phonenumber)
        imagesList.add(image)
    }

    private fun postToList(){
        for(i in 1..20)
        {
            addToList("Title $i", "Desc $i", "Phone $i$i$i", R.mipmap.ic_launcher_round)
        }
    }

}