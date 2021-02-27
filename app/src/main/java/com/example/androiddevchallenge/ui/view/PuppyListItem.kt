package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyItem
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun PuppyListItem(puppy: PuppyItem, onClick: (PuppyItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp,
            modifier = Modifier.clickable(onClick = {
                onClick(puppy)
            })
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
            ) {
                Row {
                    Text(
                        text = puppy.name.toString(),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GlideImage(
                        data = puppy?.image ?: "",
                        contentDescription = "",
                        modifier = Modifier.size(100.dp),
                    ) {}
                    Text(
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 4,
                        text = puppy.description.toString(),
                        modifier = Modifier
                            .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
            }

        }
    }
}