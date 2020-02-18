package com.example.carrefourdemo.controller

import com.example.carrefourdemo.interactor.GetUserInteractor
import com.example.carrefourdemo.presenter.HomePresenter
import com.example.carrefourdemo.viewdata.HomeViewData
import javax.inject.Inject

class HomeController @Inject constructor(
    val presenter: HomePresenter,
    val getUserInteractor: GetUserInteractor

) {

    fun getUserData(username: String) {
        getUserInteractor.getUser(username).doOnNext {
            if (it.success) {
                presenter.setUserData(it.data!!)
            }

        }.subscribe()
    }




    fun getViewData(): HomeViewData {
        return presenter.mainViewModel
    }

}