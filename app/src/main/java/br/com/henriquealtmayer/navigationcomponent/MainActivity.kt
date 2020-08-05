package br.com.henriquealtmayer.navigationcomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.henriquealtmayer.navigationcomponent.bottommenunavigation.BottomMenuNavigationActivity
import br.com.henriquealtmayer.navigationcomponent.nestednavigation.NestedNavigationActivity
import br.com.henriquealtmayer.navigationcomponent.simplenavigation.SimpleNavigationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        btn_simple_navigation.setOnClickListener {
            startActivity(
                Intent(this, SimpleNavigationActivity::class.java)
            )
        }

        btn_nested_navigation.setOnClickListener {
            startActivity(
                Intent(this, NestedNavigationActivity::class.java)
            )
        }

        btn_bottom_menu.setOnClickListener {
            startActivity(
                Intent(this, BottomMenuNavigationActivity::class.java)
            )
        }
    }

}