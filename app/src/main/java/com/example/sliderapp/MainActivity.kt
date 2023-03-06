package com.example.sliderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<SlideItem>()
        list.add(SlideItem(R.drawable.image1))
        list.add(SlideItem(R.drawable.image2))
        list.add(SlideItem(R.drawable.image3))
        list.add(SlideItem(R.drawable.image4))
        list.add(SlideItem(R.drawable.image5))
        list.add(SlideItem(R.drawable.image6))

        val viewPager: ViewPager2 = findViewById(R.id.idViewPager)
        viewPager.adapter = SliderAdapter(this, list)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer =  CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.85f + r * 0.25f)
        })
        viewPager.setPageTransformer(compositePageTransformer)
    }
}