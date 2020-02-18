package com.example.carrefourdemo.di

import com.example.carrefourdemo.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule  {

    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity

}