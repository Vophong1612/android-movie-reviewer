package vn.gst.sun.moviestatistic.presenter

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import vn.gst.sun.moviestatistic.R
import vn.gst.sun.moviestatistic.presenter.home.HomeFragment
import vn.gst.sun.moviestatistic.presenter.home.HomeViewModel

class MainActivity : DaggerAppCompatActivity(), NavHost {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startToMainScreen()
    }

    private fun startToMainScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainNavContainer, HomeFragment.newInstance(), HomeFragment.TAG)
            .commit()
    }

    override fun containerId(): Int {
        return R.id.mainNavContainer
    }

    override fun navHostFragmentManager(): FragmentManager {
        return supportFragmentManager
    }
}