package com.benrostudios.covid19stats.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.benrostudios.covid19stats.data.repository.StatsRepo

class HomeViewModelFactory(
    val statsRepo: StatsRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(statsRepo) as T
    }

}