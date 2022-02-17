package com.codesquad.kotlinphotoframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding
import com.codesquad.kotlinphotoframe.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "SecondActivity"
private lateinit var binding: ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillFrame(binding.secondConstraintLayout)
    }

    private fun fillFrame(layout: View) {
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    Glide.with(this).load(it.data?.data).override(210, 210).centerCrop()
                        .into(binding.contentImage)
                    Snackbar.make(layout, "이미지를 가져왔습니다", Snackbar.LENGTH_SHORT).show()
                }
            }

        binding.imageSelectButton.setOnClickListener {
            intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            getResult.launch(intent)
        }
    }
}