package example.com.kotlinneo.view.login

import android.arch.lifecycle.MutableLiveData
import example.com.kotlinneo.view.BaseViewModel
import example.com.kotlinneo.model.LoginResponse
import example.com.kotlinneo.net.ApiClient
import example.com.kotlinneo.net.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Nishant on 27-Dec-18.
 */

class LoginViewModel : BaseViewModel(){

    var apiClient :RestApi? = ApiClient().getApiService()

    fun CheckValidation(name: String,password: String) : Boolean{
        if(name.length < 6)
            return false
        if(password.length < 5)
            return false
        return true
    }

    val loginData: MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()

    fun getLoginResponse():MutableLiveData<LoginResponse> = loginData

    fun doLogin(name:String, password: String){
        apiClient?.login(name,password)?.enqueue(object : Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                loginData.postValue(null)
            }

            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                loginData.postValue(response?.body())
            }

        })

    }
}
