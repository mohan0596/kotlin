package example.com.kotlinneo.di.component

import android.content.Context
import dagger.Component
import example.com.kotlinneo.di.module.ActivityModule
import example.com.kotlinneo.navigator.Navigator
import javax.inject.Singleton

/**
 * Created by Nishant on 22-Apr-19.
 */
@Singleton
@Component(modules = arrayOf(ActivityModule::class))
interface AppComponent{
    fun navigator() : Navigator

    fun getContext() : Context

}