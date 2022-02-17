package com.codesquad.kotlinphotoframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "SecondActivity"
private lateinit var binding: ActivityMainBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate")

        val btn_close = findViewById<Button>(R.id.btn_close)

        btn_close.setOnClickListener {
            setResult(RESULT_OK, Intent(this, MainActivity::class.java))
            finish()
        }

    }

}