package com.example.androiddevchallenge.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.data.PuppyItem

class PuppyListViewModel : ViewModel() {
    var items: List<PuppyItem> by mutableStateOf(listOf())
        private set

    init {
        items = MockData.list
    }

    // event: addItem
    fun addItem(item: PuppyItem) {
        items = items + listOf(item)
    }

    // event: removeItem
    fun removeItem(item: PuppyItem) {
        items = items.toMutableList().also {
            it.remove(item)
        }
    }
}