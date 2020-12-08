package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_screen_layout.*

class LoginFragment:Fragment() {

    private val sharedPreferences: SharedPreferences? by lazy {
        this.context?.applicationContext?.getSharedPreferences("THIS_APP", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (sharedPreferences?.getBoolean("IS_LOGIN", false) == true) {
            switchContent(R.id.mainFrame, MainFragment())
        }
        return inflater.inflate(R.layout.login_screen_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener {
            if (userTextBox.text.toString() == "huy" &&
                    ppTextBox.text.toString() == "123") {
                sharedPreferences?.edit()?.putBoolean("IS_LOGIN", true)?.apply()
                switchContent(R.id.mainFrame, MainFragment())
            }
        }
    }
}