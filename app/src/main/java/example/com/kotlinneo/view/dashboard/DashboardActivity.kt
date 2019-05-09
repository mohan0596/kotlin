package example.com.kotlinneo.view.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import example.com.kotlinneo.R
import example.com.kotlinneo.view.BaseActivity

class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        //fragmentTransaction(ADD_FRAGMENT,DashboardFragment.newInstance(),R.id.container,false)
        mNavigator.navigateToDashboardFragment(this,R.id.container)
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context,DashboardActivity::class.java)
        }
    }
}
