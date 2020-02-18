package com.example.carrefourdemo.presenter

import com.example.carrefourdemo.model.Repo
import com.example.carrefourdemo.viewdata.ProjectListViewData
import javax.inject.Inject

class ProjectListPresenter @Inject constructor(val viewData: ProjectListViewData) {
    fun setRepoList(list: List<Repo>) {
        viewData.setRepoList(list)
    }
}