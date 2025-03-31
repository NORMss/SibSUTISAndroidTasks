package ru.normno.sibsutisandroidtask7

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit

object ThemeManager {
    private const val THEME_PREFERENCE = "theme_preference"
    private const val SELECTED_THEME = "selected_theme"

    enum class Theme(val themeName: String) {
        LIGHT("Light"),
        DARK("Dark"),
        BLUE("Blue"),
        SYSTEM("System")
    }

    fun applyTheme(theme: Theme, context: Context) {
        saveThemePreference(theme, context)

        when (theme) {
            Theme.LIGHT -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                if (context is Activity) {
                    context.setTheme(R.style.Theme_MyApp_Light)
                }
            }
            Theme.DARK -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                if (context is Activity) {
                    context.setTheme(R.style.Theme_MyApp_Dark)
                }
            }
            Theme.BLUE -> {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                if (context is Activity) {
//                    context.setTheme(R.style.T)
//                }
            }
            Theme.SYSTEM -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                if (context is Activity) {
                    context.setTheme(R.style.Theme_MyApp_Light) // или другая базовая тема
                }
            }
        }
    }

    // Получаем текущую тему
    fun getCurrentTheme(context: Context): Theme {
        val prefs = context.getSharedPreferences(THEME_PREFERENCE, Context.MODE_PRIVATE)
        val themeName = prefs.getString(SELECTED_THEME, Theme.SYSTEM.name) ?: Theme.SYSTEM.name
        return Theme.valueOf(themeName)
    }

    // Сохраняем выбор темы в SharedPreferences
    private fun saveThemePreference(theme: Theme, context: Context) {
        val prefs = context.getSharedPreferences(THEME_PREFERENCE, Context.MODE_PRIVATE)
        prefs.edit { putString(SELECTED_THEME, theme.name) }
    }
}