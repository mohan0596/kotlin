package example.com.kotlinneo.di

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * Created by Nishant on 23-Apr-19.
 */
@Scope
@Retention(RUNTIME)
annotation class PerActivity