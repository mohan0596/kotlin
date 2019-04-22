package example.com.kotlinneo.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.util.zip.Inflater

/**
 * Created by Nishant on 22-Apr-19.
 */
abstract class BaseFragment<T : BaseViewModel> : Fragment(){

    abstract fun getLayout():Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView :View = inflater.inflate(getLayout(),container,false)
        return  rootView

    }

    fun showErrorMessage(message: String){
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}