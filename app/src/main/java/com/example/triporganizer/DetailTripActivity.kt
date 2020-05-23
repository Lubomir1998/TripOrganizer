package com.example.triporganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface

class DetailTripActivity : AppCompatActivity() {

   // private lateinit var slider: SlidrInterface
      lateinit var dots: Array<ImageView?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_trip)


        val tripNameTextView: TextView = findViewById(R.id.nameTextview)
        val nameT: String = intent.getStringExtra("name")
        val sliderPhotosOfCities: ArrayList<Int> = intent.getIntegerArrayListExtra("photolist")
        val adapter = SlideAdapter(this, sliderPhotosOfCities)

        val pager = findViewById<ViewPager>(R.id.viewPager)

        val sliderDotsLayout = findViewById<LinearLayout>(R.id.dots_layout)

        // set the adapter
        pager.adapter = adapter



        // creates the back arrow at the actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = nameT
        tripNameTextView.text = nameT

       // slider = Slidr.attach(this)

        dots = arrayOfNulls(adapter.count)

        for(i in 0 until adapter.count){
            dots[i] = ImageView(this)
            dots[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))

            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            params.setMargins(8, 0, 8, 0)

            sliderDotsLayout.addView(dots[i], params)
        }

        dots[0]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))

        pager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                for(i in 0 until adapter.count){
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))

            }

        })

    }


}
