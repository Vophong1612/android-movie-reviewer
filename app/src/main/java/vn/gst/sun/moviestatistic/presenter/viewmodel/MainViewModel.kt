package vn.gst.sun.moviestatistic.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.moviestatistic.framework.repository.UseCases

class MainViewModel @Inject constructor(
    private val useCases: UseCases
) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private var _listMovies = MutableLiveData<List<Movie>>()
    val listMovies: LiveData<List<Movie>> = _listMovies

    fun getPopularMovies() {
        val flowable = useCases.getPopularMovies.invoke()
        compositeDisposable.add(
            flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _listMovies.postValue(it)
                }, {
                    setError(it)
                })
        )
    }

    fun release() {
        compositeDisposable.clear()
    }
}