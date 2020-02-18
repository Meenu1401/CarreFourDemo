package com.example.carrefourdemo.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.carrefourdemo.DisposableOnNextObserver
import com.example.carrefourdemo.R
import com.example.carrefourdemo.controller.HomeController
import com.example.carrefourdemo.model.User
import com.example.carrefourdemo.CarreFourApp
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private var navController: NavController? = null

    @Inject
    lateinit var homeController: HomeController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        CarreFourApp.instance.applicationInjector().injectHome(this)
        observeData()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        if (!isNetworkConnected()) {
            navController!!.navigate(R.id.action_homeFragment_to_networkFragment)
        }

        progressbar.visibility = View.GONE


        btn_get_profile.setOnClickListener {
            if (username.text.toString().trim().isNotEmpty()) {
                progressbar.visibility = View.VISIBLE
                homeController.getUserData(username.text.toString())

            } else {
                Toast.makeText(
                    activity,
                    "Please enter username",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }


    }

    private fun observeData() {
        val disposableOnNextObserver = object : DisposableOnNextObserver<User>() {
            override fun onNext(user: User) {
                navigateToDetail(user)
            }
        }
        homeController.getViewData().observeUserData().subscribe(disposableOnNextObserver)
        addDisposable(disposableOnNextObserver)
    }

    private fun navigateToDetail(user: User) {
        val bundle = bundleOf(
            "name" to user.name,
            "bio" to user.bio,
            "image" to user.avatarUrl, "website" to user.webSite, "login" to user.login
        )

        navController!!.navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }


    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

}
