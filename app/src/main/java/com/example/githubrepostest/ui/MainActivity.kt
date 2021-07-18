package com.example.githubrepostest.ui


import android.os.Bundle
import com.example.githubrepostest.R
import com.example.githubrepostest.di.Scopes
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import toothpick.Toothpick
import javax.inject.Inject


class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private val navigator = AppNavigator(this, R.id.flow_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this@MainActivity, Toothpick.openScope(Scopes.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_flow)
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}


