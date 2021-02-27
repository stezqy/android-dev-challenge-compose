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
package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyItem
import dev.chrisbanes.accompanist.glide.GlideImage
import java.text.SimpleDateFormat

@Composable
fun PuppyDetailScreen(navController: NavController) {

    val puppy = navController.previousBackStackEntry
        ?.arguments?.getParcelable<PuppyItem>("puppy")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail: ${puppy?.name ?: ""}") },
                elevation = 4.dp
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            item {
                GlideImage(
                    data = puppy?.image ?: "",
                    contentDescription = "",
                    modifier = Modifier.size(350.dp),
                ) {}
            }
            item {
                Text(
                    color = MaterialTheme.colors.primary,
                    text = "Name: ${puppy?.name}",
                )
            }
            item {
                Text(
                    text = "Publish Time: ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(puppy?.publishTime)}",
                )
            }
            item {
                Text(
                    text = "From: ${puppy?.from.toString()}",
                )
            }
            item {
                Text(
                    text = "Description: ${puppy?.description.toString()}",
                )
            }

        }

    }
}