package com.learn.utils

import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager

object Utils {
    fun disableSoftKb(activity: AppCompatActivity) {
        activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

}
