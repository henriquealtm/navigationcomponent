package br.com.henriquealtmayer.navigationcomponent.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.henriquealtmayer.navigationcomponent.R
import kotlinx.android.synthetic.main.activity_view_pager2.*

class ViewPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        val demoCollectionAdapter = DemoCollectionAdapter(this)
        pager2.adapter = demoCollectionAdapter
    }

}