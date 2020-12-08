package com.example.myapplication

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.switchContent(id: Int, fragment: Fragment, addToBackStack:Boolean = false) {
    if (this.context is MainActivity) {
        Log.d("Fragment","switchContent")
        val mainActivity = this.context as MainActivity
        mainActivity.switchContent(id, fragment, addToBackStack)
    }
}

fun AppCompatActivity.switchContent(id: Int, fragment: Fragment, addToBackStack:Boolean = false) {
    Log.d("AppCompatActivity","switchContent main activity")
    val ft = supportFragmentManager.beginTransaction()
    ft.replace(id, fragment, fragment.toString())
    if (addToBackStack) {
        ft.addToBackStack(null)
    }
    ft.commit()
}