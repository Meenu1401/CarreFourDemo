package com.example.carrefourdemo.presenter

import com.example.carrefourdemo.model.User
import com.example.carrefourdemo.viewdata.HomeViewData
import javax.inject.Inject

class HomePresenter @Inject constructor(val mainViewModel: HomeViewData) {
    fun setUserData(user: User) {
        mainViewModel.setUserData(user)
    }

}