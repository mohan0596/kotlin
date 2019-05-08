package example.com.kotlinneo.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import example.com.kotlinneo.App
import example.com.kotlinneo.R
import example.com.kotlinneo.navigator.Navigator
import kotlinx.android.synthetic.main.activity_base.*

open  class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    var mProgressDialog: ProgressDialog? = null
    lateinit var mNavigator: Navigator
    val ADD_FRAGMENT : Int = 0;
    val REPLACE_FRAGMENT : Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavigator = Navigator()

    }


    override fun setContentView(layoutResID: Int) {
        super.setContentView(R.layout.activity_base)
        container?.addView(LayoutInflater.from(this).inflate(layoutResID, null))
        //setFullScreenLoader()

    }

    fun setFullScreenLoader() {
        mProgressDialog = ProgressDialog(this)
        mProgressDialog?.setCancelable(false)
    }

    fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showErrorMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    fun fragmentTransaction(transactionType:Int, fragment: Fragment, container:Int, isAddtoBackStack:Boolean){
        val trans : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(transactionType){
            0 -> trans.add(container,fragment,fragment.javaClass.simpleName)

            1 -> {
                trans.replace(container,fragment,fragment.javaClass.simpleName)
                if(isAddtoBackStack)
                    trans.addToBackStack(null)
            }

        }

        trans.commit()
    }


}
