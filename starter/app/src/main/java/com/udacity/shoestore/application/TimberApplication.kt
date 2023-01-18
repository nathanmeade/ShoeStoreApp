package com.udacity.shoestore.application

import android.app.Application
import com.udacity.shoestore.BuildConfig
import timber.log.Timber

class TimberApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}