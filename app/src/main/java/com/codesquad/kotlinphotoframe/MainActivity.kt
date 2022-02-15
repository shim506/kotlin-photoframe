package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Switch
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.Dimension
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var constLaytout = findViewById<View>(R.id.const_layout)
        val myName: TextView = findViewById(R.id.tv_MyName)
        val myButton: TextView = findViewById(R.id.btn_myButton)
        val swDarkMode: Switch = findViewById(R.id.sw_darkMode)


        myName.text = "Jay의 사진 액자"
        myName.setTextSize(Dimension.SP, 40F)


        // 회색
        myName.setTextColor(Color.rgb(146, 146, 146))

        // 하늘색
        myName.setBackgroundColor(Color.parseColor("#89a5ea"))


        Log.d(TAG, "onCreate")


        myButton.text = "다음"

        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                if (it.resultCode == RESULT_OK) {
                        Snackbar.make(constLaytout, "사진을 불러옵니다", Snackbar.LENGTH_SHORT).show()
                }
            }
        myButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getResult.launch(intent)
        }


        /*
        myButton.setOnClickListener {
            // 사진 불러오는 작업 구현필요
            Snackbar.make(constlaytout, "사진을 불러옵니다", Snackbar.LENGTH_SHORT).setAction("취소") {
                Log.d(TAG, "사진을 불러오는 작업 취소")
            }
                .show()
        }*/

        swDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }


}