package com.example.sliderapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter(private val context: Context,
                    private val imageList : ArrayList<SlideItem>) : RecyclerView.Adapter<SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.slide_item_container, parent, false)
        return SliderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.imageHolder.setImageResource(currentItem.imageId)
    }
}

class SliderViewHolder(item: View): RecyclerView.ViewHolder(item){
    val imageHolder: RoundedImageView = item.findViewById(R.id.sliderItem)
}