package com.example.wheretoeat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat.R
import com.example.wheretoeat.Room.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProfileScreenFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.profile_screen, container, false)



        //user szerkesztes

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readData.observe(viewLifecycleOwner, Observer {user ->
            view.findViewById<TextView>(R.id.fullName).text = user.Name
            view.findViewById<TextView>(R.id.email).text = user.Email
            view.findViewById<TextView>(R.id.adress).text = user.Country
            view.findViewById<TextView>(R.id.phoneNumber).text = user.Phone

        })

        //-------


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}