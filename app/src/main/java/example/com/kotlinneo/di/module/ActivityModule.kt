package example.com.kotlinneo.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by Nishant on 22-Apr-19.
 */

@Module
class ActivityModule{
    var activity : Activity

    constructor(activity: Activity) {
        this.activity = activity
    }

    @Provides
    fun provideActivity():Activity{
        return this.activity
    }
}