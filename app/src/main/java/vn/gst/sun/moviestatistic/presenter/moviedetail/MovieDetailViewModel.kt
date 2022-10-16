package vn.gst.sun.moviestatistic.presenter.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.UseCases
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import vn.gst.sun.lib.data.Movie
import vn.gst.sun.lib.data.MovieDetail
import vn.gst.sun.moviestatistic.presenter.viewmodel.BaseViewModel

class MovieDetailViewModel @Inject constructor(
    private val useCases: UseCases
): BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail> = _movieDetail

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovie: LiveData<List<Movie>> = _similarMovies

    fun getMovieDetail(movieId: Int) {
        val flowable = useCases.getMovieDetail.invoke(movieId)
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
                    _movieDetail.postValue(it)
                }, {
                    setError(it)
                })
        )
    }

    fun getSimilarMovie(movieId: Int) {
        val flowable = useCases.getSimilarMovie.invoke(movieId)
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
                    _similarMovies.postValue(it)
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