package com.digitaloptions.randommultiply

import android.view.View
import android.widget.ScrollView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.digitaloptions.randommultiply.HomeViewModel



private const val GRID_SPAN_COUNT = 2

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
){
    val random1 = homeViewModel.random1.value
    val random2 = homeViewModel.random2.value
    val options = homeViewModel.optionList
    val rest = homeViewModel.rest.value


    Scaffold()
    {
      Home(
          onRandomButtonClick = { ->
              homeViewModel.getRandomNew() },
              random1,random2,options, onResultClicked = {
              homeViewModel.evaluateResult(it)
          },rest)
    }

}
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun Home(onRandomButtonClick: () -> Unit, random1:String, random2:String, options: List<Int>,onResultClicked: (Int) -> Unit,rest:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 50.dp,
                start = 0.dp,
                end = 4.dp,
                bottom = 0.dp,

                ),
    ){
       RowHome(random1 = random1, random2 =random2 , result =rest )
        Grid(options = options, onResultClicked =onResultClicked )
        Button(modifier = Modifier
            .width(160.dp)
            .padding(top = 20.dp)
            .align(CenterHorizontally)
            .semantics { testTag = "login-button" },
            onClick = {onRandomButtonClick()  }) {
            Text(
                stringResource(R.string.Random),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }



    }

}

@Composable
fun RowHome (random1:String,random2:String,result:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 0.dp, end = 4.dp, bottom = 0.dp)
        ,
    ) {
        Greeting(name = random1)
        Greeting("X")
        Greeting(name = random2)
        Greeting("=")
        Greeting(name = result)

    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        Text ( text = name,color = Color.Red, textAlign = TextAlign.End,
            modifier = Modifier.width(65.dp), fontSize = 30.sp, fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontStyle = FontStyle.Italic)
    }

}


@Composable
fun LoginScreenToolbar() {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        backgroundColor = Color.Red,
        contentColor = Color.White,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Grid(options:List<Int>, onResultClicked: (Int) -> Unit){
    LazyVerticalGrid(
        cells = GridCells.Fixed(GRID_SPAN_COUNT),
        content = {
            items(options) {
                Item(option = it, onResultClicked)
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Item(option:Int, onResultClicked: (Int) -> Unit){
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .width(100.dp),
        color = Color.Red,
        onClick = { onResultClicked(option) },
        shape = RoundedCornerShape(4.dp)

    ) {
        Text(
            text = option.toString(),
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 42.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
@Preview
@Composable
fun Preview() {
        HomeScreen()
}

