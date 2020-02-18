package com.example.carrefourdemo.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carrefourdemo.CarreFourApp
import com.example.carrefourdemo.DisposableOnNextObserver
import com.example.carrefourdemo.R
import com.example.carrefourdemo.adapter.RepoAdapter
import com.example.carrefourdemo.controller.ProjectListController
import com.example.carrefourdemo.model.Repo
import kotlinx.android.synthetic.main.fragment_repos_list.*
import javax.inject.Inject

class ReposListFragment : BaseFragment() {

    lateinit var repoAdapter: RepoAdapter

    @Inject
    lateinit var listController: ProjectListController

    private var user: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = arguments!!.getString("login")
        CarreFourApp.instance.applicationInjector()?.inject(this)
        observeRepoList()

    }

    private fun observeRepoList() {
        val disposableOnNextObserver = object : DisposableOnNextObserver<List<Repo>>() {
            override fun onNext(repos: List<Repo>) {
                setAdapter(repos)
            }
        }
        listController.getViewData().observeRepoList().subscribe(disposableOnNextObserver)
        addDisposable(disposableOnNextObserver)
    }

    private fun setAdapter(repos: List<Repo>) {
        repoAdapter = RepoAdapter(repos)
        if (rv_repos != null) {
            rv_repos.setHasFixedSize(true)
            rv_repos.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            rv_repos.adapter = repoAdapter
        }
        if (progressbar != null)
            progressbar.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_repos_list, container, false)
        val progressbar = view.findViewById<ProgressBar>(R.id.progressbar)

        progressbar.visibility = View.VISIBLE

        listController.getRepoList(user!!)

        return view
    }


}
