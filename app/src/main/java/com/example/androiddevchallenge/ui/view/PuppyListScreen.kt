package com.example.androiddevchallenge.ui.view

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.model.PuppyListViewModel

@Composable
fun PuppyListScreen(viewModel: PuppyListViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.primary,
            )
        },
        content = {
            ListScreen(viewModel.items) {
                navController.currentBackStackEntry
                    ?.arguments?.putParcelable("puppy", it)
                navController.navigate("detail")
            }
        }
    )
}


@Composable
private fun ListScreen(puppyList: List<PuppyItem>, onClick: (PuppyItem) -> Unit) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(puppyList) {
            PuppyListItem(it, onClick)
        }
    }
}