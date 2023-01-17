package com.example.cookbook

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout,viewPager){ tab,index ->
            tab.text = when(index){
                0 -> { "FOOD" }
                1 -> { "INGREDIENTS" }
                2 -> { "NOTES" }
                else -> { throw Resources.NotFoundException ("Position Not Found")}
            }
        }.attach()
    }
}