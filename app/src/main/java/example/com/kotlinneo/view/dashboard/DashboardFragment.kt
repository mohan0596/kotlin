package example.com.kotlinneo.view.dashboard

import example.com.kotlinneo.R
import example.com.kotlinneo.view.BaseFragment

/**
 * Created by Nishant on 22-Apr-19.
 */
class DashboardFragment : BaseFragment<DashboardViewModel>(){

    override fun getLayout(): Int {
        return R.layout.fragment_dashboard
    }

    companion object {
        fun newInstance() : DashboardFragment{
            val fragment  = DashboardFragment()
            return fragment
        }
    }

}