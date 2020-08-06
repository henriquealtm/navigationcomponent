package br.com.henriquealtmayer.navigationcomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.henriquealtmayer.navigationcomponent.bottommenu.BottomMenuNavigationActivity
import br.com.henriquealtmayer.navigationcomponent.nested.NestedNavigationActivity
import br.com.henriquealtmayer.navigationcomponent.simple.SimpleNavigationActivity
import br.com.henriquealtmayer.navigationcomponent.viewpager.ViewPagerActivity
import br.com.henriquealtmayer.navigationcomponent.viewpager2.ViewPager2Activity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        initializeButtonOnClick(btn_simple_navigation, NestedNavigationActivity::class.java)

        initializeButtonOnClick(btn_nested_navigation, NestedNavigationActivity::class.java)

        initializeButtonOnClick(btn_bottom_menu, BottomMenuNavigationActivity::class.java)

        initializeButtonOnClick(btn_view_pager, ViewPagerActivity::class.java)

        initializeButtonOnClick(btn_view_pager2, ViewPager2Activity::class.java)

    }

    private fun initializeButtonOnClick(
        button: Button,
        appCompatActivityClass: Class<out AppCompatActivity>
    ) {
        button.setOnClickListener {
            startActivity(
                Intent(this, appCompatActivityClass)
            )
        }
    }

}



















