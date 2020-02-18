package com.example.carrefourdemo.di

import android.content.Context

import com.example.carrefourdemo.controller.HomeController
import com.example.carrefourdemo.interactor.GetUserInteractor
import com.example.carrefourdemo.presenter.HomePresenter
import com.example.carrefourdemo.viewdata.HomeViewData
import com.example.carrefourdemo.CarreFourApp
import com.example.carrefourdemo.controller.ProjectListController
import com.example.carrefourdemo.interactor.ProjectListInteractor
import com.example.carrefourdemo.presenter.ProjectListPresenter
import com.example.carrefourdemo.viewdata.ProjectListViewData
import dagger.Module
import dagger.Provides

@Module
class AppModule {


    @Provides
    @AppScope
    fun context(app: CarreFourApp): Context {
        return app
    }

    @Provides
    @AppScope
    fun homePresenter(mainViewModel: HomeViewData): HomePresenter {
        return HomePresenter(mainViewModel)
    }

    @Provides
    @AppScope
    fun mainViewModel(): HomeViewData {
        return HomeViewData()
    }

    @Provides
    @AppScope
    fun getUserInteractor(): GetUserInteractor {
        return GetUserInteractor()
    }


    @Provides
    @AppScope
    fun projectListInteractor(): ProjectListInteractor {
        return ProjectListInteractor()
    }

    @Provides
    @AppScope
    fun homeController(
        presenter: HomePresenter,
        getUserInteractor: GetUserInteractor
    ): HomeController {
        return HomeController(presenter, getUserInteractor)
    }



    @Provides
    @AppScope
    fun listPresenter(viewData: ProjectListViewData): ProjectListPresenter {
        return ProjectListPresenter(viewData)
    }

    @Provides
    @AppScope
    fun projectListViewData(): ProjectListViewData{
        return ProjectListViewData()
    }


    @Provides
    @AppScope
    fun projectListController(
        presenter: ProjectListPresenter,
        listInteractor: ProjectListInteractor
    ): ProjectListController {
        return ProjectListController(presenter, listInteractor)
    }


}
