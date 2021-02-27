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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyItem
import dev.chrisbanes.accompanist.glide.GlideImage
import java.text.SimpleDateFormat

@Composable
fun PuppyDetailScreen(navController: NavController) {

    val puppy = navController.previousBackStackEntry
        ?.arguments?.getParcelable<PuppyItem>("puppy")
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Detail: ${puppy?.name ?: ""}") },
            elevation = 4.dp
        )
    }) {
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
                    text = "Name: ${puppy?.name.toString()}",
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