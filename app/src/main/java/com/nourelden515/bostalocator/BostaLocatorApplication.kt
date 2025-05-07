package com.nourelden515.bostalocator

import android.app.Application
import com.nourelden515.bostalocator.di.ApplicationComponent

class BostaLocatorApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.create(this)
    }
}