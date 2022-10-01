package vn.gst.sun.moviestatistic.presenter.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<Throwable>()

    val error: LiveData<Throwable>
        get() = _error

    @MainThread
    protected fun setLoading(loading: Boolean) {
        _isLoading.postValue(loading)
    }

    @MainThread
    protected fun setError(error: Throwable) {
        _error.postValue(error)
    }
}