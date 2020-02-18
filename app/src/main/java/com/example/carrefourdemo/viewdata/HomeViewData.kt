package com.example.carrefourdemo.viewdata

import com.example.carrefourdemo.model.User
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class HomeViewData @Inject constructor() {

    private val userData = BehaviorSubject.create<User>()


    fun observeUserData(): BehaviorSubject<User> {
        return userData
    }


    fun setUserData(user: User) {
        userData.onNext(user)
    }

}