package com.example.carrefourdemo


import androidx.lifecycle.LifecycleObserver
import com.example.urltestapp.di.AppComponent
import com.example.urltestapp.di.DaggerAppComponent
import dagger.android.support.DaggerApplication


class CarreFourApp : DaggerApplication(), LifecycleObserver {

    private lateinit var androidInjector: AppComponent

    init {
        instance = this

    }

    public override fun applicationInjector(): AppComponent {
        return androidInjector
    }


    override fun onCreate() {
        this.androidInjector = DaggerAppComponent.factory().create(this) as DaggerAppComponent
        super.onCreate()
    }


    companion object {
        lateinit var instance: CarreFourApp
    }
}