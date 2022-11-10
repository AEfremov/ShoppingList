package ru.efremov.shoppinglist

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import ru.efremov.shoppinglist.di.DaggerApplicationComponent

class ShoppingListApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}