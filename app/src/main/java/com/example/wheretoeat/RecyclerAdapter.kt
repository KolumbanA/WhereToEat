package com.example.wheretoeat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private var restaurant_name: List<String>, private var descriptions: List<String>, private var phonenumbers: List<String>,
                      private var images: List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemName: TextView = itemView.findViewById(R.id.tv_restaurant_name)
        val itemDescription: TextView = itemView.findViewById(R.id.tv_restaurant_description)
        val itemPhoneNumber: TextView = itemView.findViewById(R.id.tv_restaurant_phone)
        val itemPicture: ImageView = itemView.findViewById(R.id.iv_restaurant_image)


        init{
            itemView.setOnClickListener{v: View? ->  
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"You clicked on item number ${position + 1}", Toast.LENGTH_SHORT).show();
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return restaurant_name.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = restaurant_name[position]
        holder.itemDescription.text = descriptions[position]
        holder.itemPhoneNumber.text = phonenumbers[position]
        holder.itemPicture.setImageResource(images[position])

    }
}