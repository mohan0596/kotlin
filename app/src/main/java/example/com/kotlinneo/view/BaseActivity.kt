package example.com.kotlinneo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.kotlinneo.R

open class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }


}
