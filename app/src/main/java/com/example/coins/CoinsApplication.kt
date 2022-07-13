package com.example.coins

import android.app.Application
import com.example.coins.di.initKoin
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class CoinsApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
    }
}