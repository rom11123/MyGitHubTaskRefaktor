package com.example.mygithubtaskrefacktor.feature_github.presentation.settings_screen


import com.example.mygithubtaskrefacktor.MyApplication
import com.example.mygithubtaskrefacktor.R

class ThemeSettings: MyApplication() {
    companion object{
        var   PREFERENCES = "preferences"

        var CUSTOM_THEME = "customTheme"
        var LIGHT_THEME = R.style.Theme_MyGithubTaskRefacktor.toString()
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