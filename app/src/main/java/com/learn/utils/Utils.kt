package com.learn.utils

import android.app.Activity
import android.view.WindowManager

object Utils {
    fun disableSoftKb(activity: Activity) {
        activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

}
