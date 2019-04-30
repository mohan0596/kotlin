package example.com.kotlinneo.navigator

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import example.com.kotlinneo.view.dashboard.DashboardActivity
import example.com.kotlinneo.view.dashboard.DashboardFragment

/**
 * Created by Nishant on 22-Apr-19.
 */
class Navigator {
    fun navigateToDashboard(context: Context) {
        val intent: Intent = DashboardActivity.getCallingIntent(context)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToDashboardFragment(activity: FragmentActivity, container: Int) {
        addFragment(activity, container, DashboardFragment.newInstance(), DashboardFragment.javaClass.simpleName)
    }

    fun addFragment(activity: FragmentActivity, container: Int, fragment: Fragment, tag: String) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        fragmentManager.beginTransaction().add(container, fragment, tag).commit()

    }

    fun replaceFragment(activity: FragmentActivity, container: Int, fragment: Fragment, tag: String, isAddToBackStack: Boolean) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container, fragment, tag)
        if (isAddToBackStack)
            fragmentTransaction.addToBackStack(null)
    }

}