package vn.gst.sun.moviestatistic.presenter.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.UseCases
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.moviestatistic.presenter.viewmodel.BaseViewModel

class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private var _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> = _popularMovies

    private var _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies: LiveData<List<Movie>> = _topRatedMovies

    fun getPopularMovies() {
        val flowable = useCases.getPopularMovies.invoke()
        compositeDisposable.add(
            flowable.subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    setLoading(true)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    setLoading(false)
                }
                .subscribe({
                    _popularMovies.postValue(it)
                }, {
                    setError(it)
                })
        )
    }

    fun getTopRatedMovies() {
        val flowable = useCases.getTopRatedMovies.invoke()
        compositeDisposable.add(
            flowable.subscribeOn(Schedulers.io())
                .doOnSubscribe { setLoading(true) }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { setLoading(false) }
                .subscribe({
                    _topRatedMovies.postValue(it)
                }, {
                    setError(it)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}