package com.codesquad.kotlinphotoframe

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlin.coroutines.coroutineContext

class MyImage(private val filePath: String, private val assetManager: AssetManager) {
    var imageData: Bitmap? = null

    fun getImage(): Bitmap {

        if (imageData == null) {
            // step 1. asset 폴더에서 파일 열기
            val inputStream = assetManager.open(filePath)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageData = bitmap
        }
        return imageData as Bitmap
    }

}