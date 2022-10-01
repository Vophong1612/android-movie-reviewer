package vn.gst.sun.moviestatistic.presenter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import vn.gst.sun.moviestatistic.R
import vn.gst.sun.moviestatistic.presenter.home.HomeFragment
import vn.gst.sun.moviestatistic.presenter.home.HomeFragmentView
import vn.gst.sun.moviestatistic.presenter.viewmodel.MainViewModel

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*setContent {
            Text(text = "Hello World")
        }*/

        /*findViewById<View>(R.id.helloText).setOnClickListener {
            mainViewModel.getPopularMovies()
        }*/

        startToMainScreen()


        mainViewModel.listMovies.observe(this) {
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            val x = it
        }

        mainViewModel.error.observe(this) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startToMainScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainNavContainer, HomeFragment.newInstance(), HomeFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel.release()
    }
}