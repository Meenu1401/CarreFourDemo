package com.example.carrefourdemo


import android.content.Context
import androidx.lifecycle.LifecycleObserver
import com.example.urltestapp.di.AppComponent
import com.example.urltestapp.di.DaggerAppComponent
import dagger.android.support.DaggerApplication


class CarreFourApp : DaggerApplication(), LifecycleObserver {

    private var androidInjector: AppComponent? = null
    init {
        instance = this

    }

    public override fun applicationInjector(): AppComponent? {
        return androidInjector
    }


    override fun onCreate() {
        this.androidInjector = DaggerAppComponent.factory().create(this) as DaggerAppComponent
        super.onCreate()
    }



    companion object {
        lateinit var instance: CarreFourApp



        val appContext: Context
            get() = instance.applicationContext
    }
}