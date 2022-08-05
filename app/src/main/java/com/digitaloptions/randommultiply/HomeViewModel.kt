package com.digitaloptions.randommultiply

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
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
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel  @Inject constructor(application: Application): AndroidViewModel(application)
{
    val mp: MediaPlayer = MediaPlayer.create(application, R.raw.audio)

    var optionList  = mutableListOf<Int>()
        private set
    var random1 = mutableStateOf<String>("")
        private set
    var random2 = mutableStateOf<String>("")
        private set
    var result = mutableStateOf<Int>(0)
        private set
    var rest = mutableStateOf<String>("")
        private set
    init {
        getRandomInitial()
    }

    private fun getRandomInitial() {
        var r =Random.nextInt(1, 4)
        random1.value= Random.nextInt(1, 10).toString()
        random2.value= Random.nextInt(1, 10).toString()
        result.value= (random1.value.toInt() * random2.value.toInt())


        when (r) {
            1 -> {
                optionList.add(result.value)
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 51))
            }
            2 -> {
                optionList.add(Random.nextInt(1, 81))
                optionList.add(result.value)
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 51))
            }
            3 -> {
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 81))
                optionList.add(result.value)
                optionList.add(Random.nextInt(1, 51))
            }
            else -> {
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 51))
                optionList.add(result.value)

            }
        }
    }

    fun getRandomNew() {
        var r =Random.nextInt(1, 4)
        random1.value= Random.nextInt(1, 10).toString()
        random2.value= Random.nextInt(1, 10).toString()
        rest.value=""
        result.value= (random1.value.toInt() * random2.value.toInt())
        optionList = mutableListOf<Int>()

        when (r) {
            1 -> {
                optionList.add(result.value)
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 51))
            }
            2 -> {
                optionList.add(Random.nextInt(1, 81))
                optionList.add(result.value)
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 51))
            }
            3 -> {
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 81))
                optionList.add(result.value)
                optionList.add(Random.nextInt(1, 51))
            }
            else -> {
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 81))
                optionList.add(Random.nextInt(1, 51))
                optionList.add(result.value)

            }
        }

    }

    fun evaluateResult(option:Int) {
        rest.value="Fail"
       if(option===result.value){
           mp.start();
           rest.value="Ok"
           getRandomNew()
       }

    }


}
