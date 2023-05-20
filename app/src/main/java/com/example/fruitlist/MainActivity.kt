package com.example.fruitlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fruitlist.ui.theme.FruitListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruitListTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    FruitList()
                }
            }
        }
    }
}
data class Fruit(
    val title:String
)
val fruitList = arrayListOf<String>(
    "Apple",
    "Banana",
    "Orange",
    "Pomegranate"
)

@Composable
fun FruitList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(fruitList){
            it-> row(it)
        }
    }
}
@Composable
fun row(fruit : String){
    Text(text= "NAME: $fruit",modifier = Modifier.padding(8.dp))
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FruitListTheme {
        FruitList()
    }
}