package com.example.carrefourdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.carrefourdemo.CarreFourApp
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseFragment : Fragment() {
    private var compositeDisposable: CompositeDisposable? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }


    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable?.dispose()
        compositeDisposable = null
        super.onDestroy()
    }

}