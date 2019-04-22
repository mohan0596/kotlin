package example.com.kotlinneo.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import example.com.kotlinneo.R
import example.com.kotlinneo.navigator.Navigator
import kotlinx.android.synthetic.main.activity_base.*

open abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    var mProgressDialog: ProgressDialog? = null
    lateinit var mNavigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // injectComponent()
       // initViewmodel()
        injectNavigator()
        mNavigator = Navigator()

    }

  //  abstract fun initViewmodel()
   // abstract fun injectComponent()

    /**
     * TODO
     *  intialize mNavigator
     */
    private fun injectNavigator() {
     //   mNavigator = ((application as UserApplication).getComponent()?.navigator())

    }

    /**
     * TODO
     * child should override for retry on API failure
     */
    fun retry() {

    }

    /**
     * TODO
     * set toolbar with back arrow
     * @param title
     */
   /* fun setToolbar(title: String) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val mToolBarTitle = toolbar.findViewById<TextView>(R.id.txt_title)
        mToolBarTitle.setText(title)

    }*/

    override fun setContentView(layoutResID: Int) {
        super.setContentView(R.layout.activity_base)
        container?.addView(LayoutInflater.from(this).inflate(layoutResID, null))
        setFullScreenLoader()

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


}
