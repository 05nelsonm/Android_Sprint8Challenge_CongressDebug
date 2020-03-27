package com.lambdaschool.congressdata

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences


object themeUtils {

    private var prefs: SharedPreferences? = null
    private var cTheme: Int = 0
    private var counter: Int = 0

    fun nextTheme(activity: Activity) {
        prefs = activity.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = prefs!!.edit()

        when (counter) {
            0 -> cTheme = R.style.AppTheme_Lambda_Dark
            1 -> cTheme = R.style.AppTheme
            2 -> cTheme = R.style.AppTheme_Dark
            3 -> cTheme = R.style.AppTheme_Lambda
        }
        counter = (counter + 1) % 4

        editor.putInt("Theme", cTheme)
        editor.putInt("Counter", counter)
        editor.apply()
        changeToTheme(activity, cTheme)
    }

    fun changeToTheme(activity: Activity, theme: Int) {
        cTheme = theme
        val intent = activity.intent
        activity.finish()
        activity.startActivity(intent)
    }

    fun refreshActivity(activity: Activity) {
        val intent = activity.intent
        activity.finish()
        activity.startActivity(intent)
    }

    fun onActivityCreateSetTheme(activity: Activity) {
        activity.setTheme(cTheme)
    }

    fun getcTheme(activity: Activity): Int {
        if (cTheme == 0) {
            prefs = activity.getSharedPreferences("prefs", Context.MODE_PRIVATE)
            cTheme = prefs!!.getInt("Theme", R.style.AppTheme)
        }
        return cTheme
    }
}
