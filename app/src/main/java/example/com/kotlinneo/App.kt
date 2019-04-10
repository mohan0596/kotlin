package example.com.kotlinneo

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by Nishant on 09-Apr-19.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}