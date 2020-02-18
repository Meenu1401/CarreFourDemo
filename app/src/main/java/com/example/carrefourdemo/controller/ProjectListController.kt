package com.example.carrefourdemo.controller

import com.example.carrefourdemo.interactor.ProjectListInteractor
import com.example.carrefourdemo.presenter.ProjectListPresenter
import com.example.carrefourdemo.viewdata.ProjectListViewData
import javax.inject.Inject

class ProjectListController @Inject constructor(
    val presenter: ProjectListPresenter,
    val projectListInteractor: ProjectListInteractor
) {


    fun getRepoList(username: String) {
        projectListInteractor.getRepoList(username).doOnNext {
            if (it.success) {
                presenter.setRepoList(it.data!!)
            }
        }.subscribe()
    }

    fun getViewData(): ProjectListViewData {
        return presenter.viewData
    }

}