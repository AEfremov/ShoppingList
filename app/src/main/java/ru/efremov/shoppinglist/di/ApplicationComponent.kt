package ru.efremov.shoppinglist.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.efremov.shoppinglist.presentation.MainActivity
import ru.efremov.shoppinglist.presentation.ShopItemFragment

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}