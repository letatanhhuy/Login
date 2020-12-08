package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var liveData:MutableLiveData<Int> = MutableLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame, LoginFragment())
                .commitNow()
        }

//        liveData.observe(this, {
//            Log.d("HUY:TEST", "new value $it")
//            textView.text = it.toString()
//        })
//
//        btnStart.setOnClickListener {
//            GlobalScope.launch(Dispatchers.IO) {
//                for (i in 1..MAX_COUNT) {
//                    val newNum = getNumber()
//                    //liveData.postValue(newNum)
//                    withContext(Dispatchers.Main){
//                        Log.d("HUY:TEST", "run 1")
//                    }
//                    Log.d("HUY:TEST", "run 2")
//                    runOnUiThread {
//                        Log.d("HUY:TEST", "run 3")
//                        textView.text = newNum.toString()
//                    }
//                    Log.d("HUY:TEST", "run 4")
//                }
//            }
//        }
    }

    private suspend fun getNumber():Int {
        number++
        delay(1000)
        return number
    }

    companion object {
        private const val MAX_COUNT = 10
        private var number = 0
    }
}

