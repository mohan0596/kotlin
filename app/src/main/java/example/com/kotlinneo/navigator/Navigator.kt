package example.com.kotlinneo.navigator

import android.content.Context
import android.content.Intent
import example.com.kotlinneo.view.dashboard.DashboardActivity

/**
 * Created by Nishant on 22-Apr-19.
 */
class Navigator{
  fun navigateToDashboard(context: Context){
      val intent : Intent = DashboardActivity.getCallingIntent(context)
      context.startActivity(intent)
  }

}