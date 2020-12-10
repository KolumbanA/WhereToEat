package com.example.wheretoeat.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wheretoeat.R
import com.example.wheretoeat.Room.User
import com.example.wheretoeat.Room.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProfileEditFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_profile, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.findViewById<Button>(R.id.b_edit_profile_submit).setOnClickListener{
            updateProfile()
        }


        //gomb vissza a profilra




        //---------

        return view
    }


    private fun updateProfile(){
        val name = view?.findViewById<EditText>(R.id.et_name)?.text.toString()
        val email = view?.findViewById<EditText>(R.id.et_email)?.text.toString()
        val phone =  view?.findViewById<EditText>(R.id.et_phone)?.text.toString()
        val address = view?.findViewById<EditText>(R.id.et_address)?.text.toString()

        if(inputCheck(name,email,phone,address))
        {
            val updateUser = User(1,name,email,phone,address)

            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "Update successful", Toast.LENGTH_LONG).show()

            val profileScreenFragment =  ProfileScreenFragment()


            getFragmentManager()?.beginTransaction()?.apply {
                replace(R.id.fl_fragment, profileScreenFragment)
                addToBackStack(null)
                commit()
            }

        }else
        {
            Toast.makeText(requireContext(), "Update unsuccessful, please fill out all fields", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(name: String, email: String, phone: String, address: String): Boolean{
        return !(TextUtils.isEmpty(name) or TextUtils.isEmpty(email) or TextUtils.isEmpty(phone) or TextUtils.isEmpty(address))
    }
}