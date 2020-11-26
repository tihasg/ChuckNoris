package com.tiago.chucknoris

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.tiago.chucknoris.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ChuckApp : Application(), HasActivityInjector {

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        DaggerAppComponent.builder().build().inject(this)
    }
}