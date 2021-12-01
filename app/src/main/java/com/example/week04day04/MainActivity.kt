package com.example.week04day04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var bottomNavigation:BottomNavigationView?= null
    private var frameLayout:FrameLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        bottomNavigationClicks()
        chooseFragment(HomeFragment(),"HOME")
    }

    private fun connectViews() {
        bottomNavigation = findViewById(R.id.bottomNav)
        frameLayout = findViewById(R.id.fContainer)
    }
    private fun bottomNavigationClicks(){
        bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    chooseFragment(HomeFragment(),"HOME")
                    supportActionBar?.title = "My text"
                }
                R.id.settings ->{
                    chooseFragment(SettingsFragment(),"SETTINGS")
                    supportActionBar?.title = "ldksjf;s"
                }
                R.id.profile ->{
                    chooseFragment(ProfileFragment(),"PROFILE")
                    supportActionBar?.title = "34875"
                }
            }
            true
        }
    }
    private fun chooseFragment(fragment:Fragment,tag:String){
        val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fContainer,fragment,tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()
    }
}