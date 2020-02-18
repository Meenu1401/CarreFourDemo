package com.example.carrefourdemo.viewdata

import com.example.carrefourdemo.model.Repo
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class ProjectListViewData @Inject constructor() {
    private val repoList = BehaviorSubject.create<List<Repo>>()


    fun observeRepoList(): BehaviorSubject<List<Repo>> {
        return repoList
    }

    fun setRepoList(list: List<Repo>) {
        repoList.onNext(list)
    }


}