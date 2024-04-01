package com.example.recipeeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun DetailedView(category: Category,navigateToRecipeScreen:()->Unit){
    Column {
        Text(text = category.strCategory)
        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb), contentDescription = "image of category", modifier = Modifier.aspectRatio(1f).fillMaxWidth())
        val scroll = rememberScrollState(0)

        Text(text = category.strCategoryDescription, textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState()))

//        LazyColumn( modifier = Modifier
//            .fillMaxWidth()
//            .height(400.dp)) {
//            item {
//                Text(
//                    text = category.strCategoryDescription,
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .height(150.dp)
//                        .verticalScroll(scroll)
//                )
//            }
//        }
    }
}