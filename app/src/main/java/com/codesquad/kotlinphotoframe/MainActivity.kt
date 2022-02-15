package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.Dimension

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv_MyName : TextView = findViewById(R.id.tv_MyName)

        tv_MyName.text = "Jay의 사진 액자"
        tv_MyName.setTextSize(Dimension.SP , 40F)


        // 회색
        tv_MyName.setTextColor(Color.rgb(146,146,146))

        // 하늘색
        tv_MyName.setBackgroundColor(Color.parseColor("#89a5ea"))


        Log.d(TAG, "onCreate")
        Log.d(TAG , tv_MyName.left.toString())

    }
}