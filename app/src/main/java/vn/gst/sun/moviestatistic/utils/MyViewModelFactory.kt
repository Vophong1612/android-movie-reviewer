package vn.gst.sun.moviestatistic.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.gst.sun.moviestatistic.framework.repository.UseCases
import vn.gst.sun.moviestatistic.presenter.viewmodel.MainViewModel

class MyViewModelFactory(private val useCases: UseCases) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(useCases) as T
    }
}