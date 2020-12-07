package com.example.wheretoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.wheretoeat.Room.User
import com.example.wheretoeat.Room.UserViewModel
import com.example.wheretoeat.fragments.ProfileEditFragment
import com.example.wheretoeat.fragments.ProfileScreenFragment
import com.example.wheretoeat.fragments.RestaurantListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment =
            RestaurantListFragment()
        val profileFragment =
            ProfileScreenFragment()

        val profileEditFragment = ProfileEditFragment()

        insertUserStarterDataToDatabase()

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


        //edit gomb a profil fragmensben
        /*

        findViewById<Button>(R.id.button_edit_profile).setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, profileEditFragment)
                addToBackStack(null)
                commit()
            }
        }

        */
        //-------------


    }

    private fun insertUserStarterDataToDatabase(){
        val user = User(1,"Temporary User", "temp@temp.temp", "Tempesztania", "0123456789")

        ViewModelProvider(this).get(UserViewModel::class.java).addUser(user)
    }


}