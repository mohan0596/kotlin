package example.com.kotlinneo.net

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by Nishant on 08-Apr-19.
 */
class ApiClient {
    var baseUrl: String? = null
    var api: Retrofit? = null

    init {
        baseUrl = "http://staging.php-dev.in:8844/trainingapp/api/users/"
        api = initRetrofit()
    }

    fun initRetrofit(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttp: OkHttpClient = OkHttpClient().newBuilder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .addInterceptor(loggingInterceptor)
                .build()

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        return Retrofit.Builder().
                baseUrl(baseUrl).
                client(okHttp).
                addConverterFactory(GsonConverterFactory.create(Gson())).
                callbackExecutor(executorService).
                build()

    }

    fun getApiService(): RestApi? {
        return api!!.create(RestApi::class.java)
    }

}