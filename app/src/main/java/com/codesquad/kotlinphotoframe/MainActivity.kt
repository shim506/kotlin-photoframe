package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.Dimension
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.util.*

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        val constLayout = findViewById<View>(R.id.constLayout)
        val myName: TextView = findViewById(R.id.tvMyName)
        val myButton: Button = findViewById(R.id.btnMyButton)
        val swDarkMode: Switch = findViewById(R.id.swDarkMode)
        val myImage: ImageView = findViewById(R.id.ivMyImage)

        myName.text = "Jay의 사진 액자"

        darkModeActivate(swDarkMode)

        /*
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    Snackbar.make(constLaytout, "사진을 불러옵니다", Snackbar.LENGTH_SHORT).show()
                }
            }
        myButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getResult.launch(intent)
        }*/

        // step 1. asset 폴더에서 파일 열기

        MyImage("", assetManager)
        val inputStream = assetManager.open("01.jpg")
        val bitmap = BitmapFactory.decodeStream(inputStream)


        // step 2. imageView에 표시
        myImage.setImageBitmap(bitmap)
        myImage.scaleType = ImageView.ScaleType.CENTER_CROP


        getRandomImage()
    }

    private fun getRandomImage(): Bitmap {
        var randValStr = (1..22).random().toString()
        val path = if (randValStr.length >= 2) "0${randValStr}.jpg" else "${randValStr}.jpg"
        MyImage(path, resources.assets).getImage()
    }


    private fun darkModeActivate(darkModeSwitch: Switch) {
        darkModeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->

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

