package br.com.henriquealtmayer.navigationcomponent.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val demoCollectionPagerAdapter = DemoCollectionPagerAdapter(supportFragmentManager)
        pager.adapter = demoCollectionPagerAdapter

//        tab_layout.setupWithViewPager(pager)
    }

}