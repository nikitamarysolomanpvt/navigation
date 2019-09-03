package com.example.parsaniahardik.kotlindrawerbasic

import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.view.View

class MainActivity : AppCompatActivity() ,FragmentTransactions{
     override fun openFragment(position: Int) {

        when (position) {
            0 -> removeAllFragment(FriendListFragment(), "Friends")
            1 -> removeAllFragment(NotificationFragment(), "Notifiaction")

            else -> {
            }
        } }
    fun removeAllFragment(replaceFragment: Fragment, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        manager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        ft.replace(R.id.container_body, replaceFragment)
        ft.commitAllowingStateLoss()
    }

    private var toolbar: Toolbar? = null
    private var drawerFragment: DrawerFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar?

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        drawerFragment = supportFragmentManager.findFragmentById(R.id.fragment_navigation_drawer) as DrawerFragment
        drawerFragment!!.setUpDrawer(R.id.fragment_navigation_drawer, findViewById<View>(R.id.drawer_layout) as DrawerLayout, toolbar!!)
    }
}
