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

        Log.d(TAG, "onCreate")

        val constLayout = findViewById<View>(R.id.const_layout)
        val myName: TextView = findViewById(R.id.tvMyName)
        val myButton: TextView = findViewById(R.id.btnMyButton)
        val swDarkMode: Switch = findViewById(R.id.swDarkMode)

        // 추후 앱 사용자에 따라 다른 데이터를 대입해줄 수 있음
        myName.text = "Jay의 사진 액자"
        myName.setTextSize(Dimension.SP, 40F)
        myButton.text = "다음"

        // 다크 모드 동작 컨트롤
        darkModeListen(swDarkMode)

        showSnackForActivityResult(myButton, SecondActivity::class.java, "사진을 불러옵니다" , constLayout)
    }

    private fun showSnackForActivityResult(myButton: TextView, targetActivity: Class<SecondActivity> , msg : String , showingView: View ) {
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) Snackbar.make(showingView, msg, Snackbar.LENGTH_SHORT).show()
            }

        myButton.setOnClickListener {
            getResult.launch(Intent(this, targetActivity))
        }
    }

    private fun darkModeListen(darkModeSwitch: Switch) {
        darkModeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
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