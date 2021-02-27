/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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