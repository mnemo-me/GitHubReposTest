package com.example.githubrepostest

import android.app.Application
import com.example.githubrepostest.di.Scopes
import com.example.githubrepostest.di.appModule
import com.github.terrakok.cicerone.Cicerone
import toothpick.Toothpick

class GitHubReposTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Toothpick.openScope(Scopes.APP_SCOPE).installModules(appModule(this))
    }
}