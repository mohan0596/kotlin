package example.com.kotlinneo.di.component

import dagger.Component
import example.com.kotlinneo.view.login.LoginActivity

/**
 * Created by Nishant on 22-Apr-19.
 */
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityComponent::class))
interface ActivityComponent{
    fun inject(activity : LoginActivity)

}