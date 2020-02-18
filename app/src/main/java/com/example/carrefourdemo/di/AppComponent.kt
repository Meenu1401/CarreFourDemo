package com.example.urltestapp.di

import com.example.carrefourdemo.di.AppScope

import com.example.carrefourdemo.controller.HomeController
import com.example.carrefourdemo.di.ActivityModule
import com.example.carrefourdemo.di.AppModule
import com.example.carrefourdemo.fragments.HomeFragment
import com.example.carrefourdemo.CarreFourApp
import com.example.carrefourdemo.fragments.BaseFragment
import com.example.carrefourdemo.fragments.ReposListFragment

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class, AppModule::class,
        ActivityModule::class]
)
interface AppComponent : AndroidInjector<CarreFourApp> {
    fun injectHome(homeFragment: HomeFragment)
    fun inject(reposListFragment: ReposListFragment)

    @Component.Factory
    interface Factory : AndroidInjector.Factory<CarreFourApp> {

    }
}