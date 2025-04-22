package com.example.searchmyshow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun UI(modifier: Modifier = Modifier, vM: MovieViewModel) {

    var movieName by vM.showName
    val stateVar by vM.movieInstance
    var enable by vM.check

    Column(
        modifier

            .fillMaxSize()
            .padding(8.dp),
        Arrangement.Top,
        Alignment.CenterHorizontally){
        Row(modifier.padding(4.dp)) {
            OutlinedTextField(
                movieName,
                { movieName = it },
                modifier.weight(1f),
                label = {Text("Search for any Show/Movie/Series")}
            )

            IconButton(
                {
                    enable = true
                    vM.movie(movieName)
                },
                modifier.padding(2.dp)){
                Icon(Icons.Default.Search, "Search movie here")
            }
        }

        if(enable){
            Box {
                when {
                    stateVar.loading -> {
                        CircularProgressIndicator(modifier.align(Alignment.Center))
                    }

                    stateVar.error != null -> {
                       Column(horizontalAlignment = Alignment.CenterHorizontally){
                            Text("something went wrong")
                            Text("try searching another show")
                        }
                    }

                    else -> {
                        GridView(stateVar.list)
                    }
                }
            }
        }
    }
}

@Composable
fun GridView(list: List<MovieData>) {
    LazyVerticalGrid(GridCells.Fixed(2), Modifier.fillMaxSize()) {
        items(list) {
                it -> CellData(it)
        }
    }
}

@Composable
fun CellData(data: MovieData ){
    Column(
        Modifier.padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(rememberAsyncImagePainter(data.Poster),
            null,
            Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            data.Title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
            )
    }

}