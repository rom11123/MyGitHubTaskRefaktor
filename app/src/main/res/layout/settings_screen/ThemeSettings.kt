package com.example.mygithubtask.presentation.settings_screen

import com.example.mygithubtask.MyApplication
import com.example.mygithubtask.R

class ThemeSettings:MyApplication() {
    companion object{
        var   PREFERENCES = "preferences"

        var CUSTOM_THEME = "customTheme"
        var LIGHT_THEME = R.style.Theme_MyGithubTask.toString()
        var DARK_THEME = com.google.android.material.R.style.Theme_Material3_Dark.toString()


    }
    private var customTheme: String? = null

    fun getCustomTheme(): String? {
        return customTheme
    }

    fun setCustomTheme(customTheme: String?) {
        this.customTheme = customTheme
    }
}