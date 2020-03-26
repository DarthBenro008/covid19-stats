package com.benrostudios.covid19stats

import android.app.Application
import com.benrostudios.covid19stats.data.StatsDataSource
import com.benrostudios.covid19stats.data.StatsDataSourceImpl
import com.benrostudios.covid19stats.data.repository.StatsRepo
import com.benrostudios.covid19stats.data.repository.StatsRepoImpl
import com.benrostudios.covid19stats.network.service.ApiService
import com.benrostudios.covid19stats.ui.home.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CovidApplication : Application(), KodeinAware {
    companion object {
        private lateinit var application: CovidApplication
        @JvmStatic
        fun getInstance(): CovidApplication {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@CovidApplication))

        bind() from singleton { ApiService()}
        bind<StatsDataSource>() with singleton { StatsDataSourceImpl(instance()) }
        bind<StatsRepo>() with singleton { StatsRepoImpl(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }


    }


}