package com.codesquad.kotlinphotoframe

import android.content.Intent
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
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

//    private lateinit var constLayout: View
//    private lateinit var tvMyName: TextView
//    private lateinit var btnMyButton: Button
//    private lateinit var swDarkMode: Switch
//    private lateinit var ivMyImage: ImageView
//    private lateinit var fabNextSheet: View

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMyName.text = "Jay의 사진 액자"

        darkModeActivate(binding.swDarkMode)

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

        imageChangeListening()
        shiftActivityListening()

    }

    private fun shiftActivityListening() {
        binding.fabNextSheet.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun imageChangeListening() {
        binding.btnMyButton.setOnClickListener {

            // step 2. imageView에 표시
            binding.ivMyImage.setImageBitmap(getRandomImage())
            binding.ivMyImage.scaleType = ImageView.ScaleType.CENTER_CROP
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


}

