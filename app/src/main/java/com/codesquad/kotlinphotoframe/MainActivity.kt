package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constlaytout = findViewById<View>(R.id.const_layout)
        val myName: TextView = findViewById(R.id.tv_MyName)
        val myButton: TextView = findViewById(R.id.btn_myButton)

        myName.text = "Jay의 사진 액자"
        myName.setTextSize(Dimension.SP, 40F)


        // 회색
        myName.setTextColor(Color.rgb(146, 146, 146))

        // 하늘색
        myName.setBackgroundColor(Color.parseColor("#89a5ea"))


        Log.d(TAG, "onCreate")
        Log.d(TAG, myName.left.toString())



        myButton.setOnClickListener {
            // 사진 불러오는 작업 구현필요

            Snackbar.make(constlaytout, "사진을 불러옵니다", Snackbar.LENGTH_SHORT).setAction("취소") {
                Log.d(TAG, "사진을 불러오는 작업 취소")
            }
                .show()
        }
    }
}