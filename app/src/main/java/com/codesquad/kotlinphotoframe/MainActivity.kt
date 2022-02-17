package com.codesquad.kotlinphotoframe

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate


private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {

    private lateinit var constLayout: View
    private lateinit var tvMyName: TextView
    private lateinit var btnMyButton: Button
    private lateinit var swDarkMode: Switch
    private lateinit var ivMyImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constLayout = findViewById<View>(R.id.constLayout)
        tvMyName = findViewById(R.id.tvMyName)
        btnMyButton = findViewById(R.id.btnMyButton)
        swDarkMode = findViewById(R.id.swDarkMode)
        ivMyImage = findViewById(R.id.ivMyImage)

        tvMyName.text = "Jay의 사진 액자"

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

        imageChange()


    }

    private fun imageChange() {
        btnMyButton.setOnClickListener {

            // step 2. imageView에 표시
            ivMyImage.setImageBitmap(getRandomImage())
            ivMyImage.scaleType = ImageView.ScaleType.CENTER_CROP
        }

    }

    private fun getRandomImage(): Bitmap {
        var randValStr = (1..22).random().toString()
        val path = if (randValStr.length < 2) "0${randValStr}.jpg" else "${randValStr}.jpg"

        return MyImage(path, resources.assets).getImage()
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

