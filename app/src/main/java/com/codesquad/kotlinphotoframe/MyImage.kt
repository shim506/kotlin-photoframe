package com.codesquad.kotlinphotoframe

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlin.coroutines.coroutineContext

private const val TAG = "MyImage"

class MyImage(private val filePath: String, private val assetManager: AssetManager) {

    var imageData: Bitmap? = null

    fun getImage(): Bitmap {
        if (imageData == null) {
            try {
                if (!pathIsOk(filePath)) {
                    throw WrongPathException(filePath)
                }
            } catch (e: WrongPathException) {
                Log.d(TAG, "문제 경로 : $filePath")
            }

            // step 1. asset 폴더에서 파일 열기
            val inputStream = assetManager.open(filePath)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageData = bitmap
        }
        return imageData as Bitmap
    }

    private fun pathIsOk(filePath: String): Boolean {
        val rightPathList = mutableListOf<String>()
        // 생성과 다른 방식으로 검증하고자 stringformat을 사용하지 않았습니다.
        for (i in 1..22) if (i < 10) rightPathList.add("0${i}.jpg") else rightPathList.add("${i}.jpg")
        return rightPathList.any { it == filePath }
    }

}