package com.example.wheretoeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.example.wheretoeat.R
import com.example.wheretoeat.RestaurantListFragment
import com.example.wheretoeat.model.Restaurant

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Restaurant>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.tv_restaurant_name)
        val adress: TextView = itemView.findViewById(R.id.tv_restaurant_address)
        val price: TextView = itemView.findViewById(R.id.tv_restaurant_price)
        val image: ImageView = itemView.findViewById(R.id.iv_restaurant_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.itemView.tv_restaurant_name.text = myList[position].name.toString()
        holder.name.text =  myList[position].name
        holder.adress.text = myList[position].address
        holder.price.text = myList[position].price.toString()

        Glide.with(holder.itemView.context)
            .load(myList[position].image_url.toString())//amit be akarok tolteni
            .placeholder(R.drawable.ic_baseline_house_24)//ha lassan tolti addig ez van
            .error(R.drawable.ic_baseline_error_outline_24)//ha nem sikerul
            .override(400, 400)//meret
            .centerCrop()
            .into(holder.image)//ide tolti be
    }

    fun setData(newList: List<Restaurant>){
        myList = newList
        notifyDataSetChanged()
    }
}