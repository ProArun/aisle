package com.example.aisle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aisle.R
import com.example.aisle.models.ProfileOfUsers
import com.squareup.picasso.Picasso


class UserAdapter(private val mList: List<ProfileOfUsers>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_recomended_people, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        Picasso.get()
            .load(ItemsViewModel.avatar)
            .into(holder.recomendedPeopleIv)
        holder.recomendedPeopleText.text = ItemsViewModel.firstName

    }


    override fun getItemCount() = if (mList.isEmpty()) 0 else mList.size

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val recomendedPeopleIv: ImageView = itemView.findViewById(R.id.recomended_people_iv)
        val recomendedPeopleText: TextView = itemView.findViewById(R.id.recomended_people_text)
    }
}
