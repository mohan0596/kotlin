package example.com.kotlinneo.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import example.com.kotlinneo.navigator.Navigator
import javax.inject.Singleton

/**
 * Created by Nishant on 22-Apr-19.
 */
@Module
class AppModule{
     var mApplication : Application

    constructor(mApplication: Application) {
        this.mApplication = mApplication
    }

    @Provides
    @Singleton
    fun provideApplication() : Application{
        return mApplication
    }

    @Provides
    @Singleton
    fun provideNavigator() : Navigator{
        return Navigator()
    }

    @Provides
    @Singleton
    fun provideContext() : Context{
        return mApplication.applicationContext
    }
}