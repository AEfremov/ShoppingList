package ru.efremov.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.efremov.shoppinglist.data.ShopListRepositoryImpl
import ru.efremov.shoppinglist.domain.DeleteShopItemUseCase
import ru.efremov.shoppinglist.domain.EditShopItemUseCase
import ru.efremov.shoppinglist.domain.GetShopListUseCase
import ru.efremov.shoppinglist.domain.ShopItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}