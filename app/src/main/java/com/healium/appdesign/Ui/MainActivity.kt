package com.healium.appdesign.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.healium.appdesign.R
import com.healium.appdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val controller = Navigation.findNavController(this , R.id.nav_host_fragment)
        val bottomNavigation = binding.bottomNavigationView
        NavigationUI.setupWithNavController(bottomNavigation , controller)
        bottomNavigation.setOnItemReselectedListener {}
        controller.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {}
                R.id.wishlistFragment -> {}
                R.id.scanFragment -> {}
                R.id.collectionFragment -> {}
                R.id.profileFragment -> {}
            }
        }
//        val radius = resources.getDimension(R.dimen.radius_small)
        val bottomNavigationViewBackground = bottomNavigation.background as MaterialShapeDrawable
        bottomNavigationViewBackground.shapeAppearanceModel =
            bottomNavigationViewBackground.shapeAppearanceModel.toBuilder()
                .setTopRightCorner(CornerFamily.ROUNDED, 80f)
                .setTopLeftCorner(CornerFamily.ROUNDED, 80f)
                .build()
    }
}