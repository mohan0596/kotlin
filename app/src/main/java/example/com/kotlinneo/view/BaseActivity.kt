package example.com.kotlinneo.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import example.com.kotlinneo.R
import kotlinx.android.synthetic.main.activity_base.*

open class BaseActivity<T : BaseViewModel> : AppCompatActivity() {
    val ADD_FRAGMENT = 1
    val REPLACE_FRAGMENT = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }

    fun showErrorMessage(errorMessage : String) = Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show()

    fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideLofaing() {
        progressBar.visibility = View.GONE
    }

    fun getContext() : Context {
        return this
    }

    fun hideKeyboard(){
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view : View? = currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if(view == null)
            view = View(this)

        imm.hideSoftInputFromWindow(view.windowToken,0)

    }

    fun fragmentTransaction(transactionType : Int ,fragment : Fragment, container : Int, addtoBackStack : Boolean){
        val trans : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(transactionType){
            0 -> trans.add(container,fragment,fragment::class.simpleName.toString())
            1 -> trans.replace(container,fragment,fragment::class.simpleName.toString())
        }
        trans.commit()
    }

}
