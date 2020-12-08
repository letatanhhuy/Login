package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_screen_layout.*

class MainFragment :Fragment() {
    private val sharedPreferences: SharedPreferences? by lazy {
        this.context?.applicationContext?.getSharedPreferences("THIS_APP", Context.MODE_PRIVATE)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_screen_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogOut.setOnClickListener {
            sharedPreferences?.edit()?.remove("IS_LOGIN")?.apply()
            switchContent(R.id.mainFrame, LoginFragment())
        }
    }
}