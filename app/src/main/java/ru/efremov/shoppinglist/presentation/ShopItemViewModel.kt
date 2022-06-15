package ru.efremov.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import ru.efremov.shoppinglist.data.ShopListRepositoryImpl
import ru.efremov.shoppinglist.domain.AddShopItemUseCase
import ru.efremov.shoppinglist.domain.EditShopItemUseCase
import ru.efremov.shoppinglist.domain.GetShopItemUseCase
import ru.efremov.shoppinglist.domain.ShopItem

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUserCase = GetShopItemUseCase(repository)
    private val addShopItemUserCase = AddShopItemUseCase(repository)
    private val editShopItemUserCase = EditShopItemUseCase(repository)

    fun getShopItem(shopItemId: Int) {
        val item = getShopItemUserCase.getShopItem(shopItemId)
    }

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name, count, true)
            addShopItemUserCase.addShopItem(shopItem)
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name, count, true)
            editShopItemUserCase.editShopItem(shopItem)
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (t: Throwable) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            // todo show error input name
            result = false
        }
        if (count <= 0) {
            // todo show error input count
            result = false
        }
        return result
    }
}