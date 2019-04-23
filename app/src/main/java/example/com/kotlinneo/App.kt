package example.com.kotlinneo

import android.app.Application
import com.facebook.stetho.Stetho
import example.com.kotlinneo.di.component.AppComponent
import example.com.kotlinneo.di.module.AppModule

/**
 * Created by Nishant on 09-Apr-19.
 */
class App : Application() {
    var mApplicationComponent : AppComponent? = null



    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }

    fun initInjector(){
        val appModule = AppModule(this)
        mApplicationComponent = DaggerAppComponent.appModule(appModule).build()

    }

    fun getApplicationComponent():AppComponent?{
        return mApplicationComponent
    }
}