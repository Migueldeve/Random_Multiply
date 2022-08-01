package com.digitaloptions.randommultiply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel  @Inject constructor(): ViewModel()
{
    var random1 = mutableStateOf<String>("")
        private set
    var random2 = mutableStateOf<String>("")
        private set
    var resulmult = mutableStateOf<String>("")
        private set
    init {
        getRandomInitial()
    }

    private fun getRandomInitial() {
        random1.value= Random.nextInt(1, 10).toString()
        random2.value= Random.nextInt(1, 10).toString()
        resulmult.value= (random1.value.toInt() * random2.value.toInt()).toString()
    }

    fun getRandomNew() {
        random1.value= Random.nextInt(1, 10).toString()
        random2.value= Random.nextInt(1, 10).toString()
        resulmult.value= (random1.value.toInt() * random2.value.toInt()).toString()

    }


}
