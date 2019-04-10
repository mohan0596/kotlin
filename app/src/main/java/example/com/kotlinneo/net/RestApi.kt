package example.com.kotlinneo.net

import example.com.kotlinneo.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Nishant on 09-Apr-19.
 */
interface RestApi {

    @POST("login")
    @FormUrlEncoded
    fun login(@Field("email") email : String,@Field("password") password : String) : Call<LoginResponse>
}