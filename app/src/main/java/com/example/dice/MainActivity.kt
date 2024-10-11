package com.example.dice

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.MutableInt
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dice.ui.theme.DiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceTheme {
                    Main__()
                }
            }
        }
    }

@Composable
fun Build_UI(modifier: Modifier = Modifier){
    val currentDie:MutableIntState = remember { mutableIntStateOf(1) }
    val dice:Array<Int> = arrayOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6 )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Color(0xFF4A4A4A))
    ) {
        Image(
            painter= painterResource(dice[currentDie.intValue]),
            contentDescription = ""
        )
        Button(onClick = { currentDie.intValue = (0..5).random() }) {
            Text(stringResource(R.string.roll))
        }

    }
}
@Composable
fun Main__(modifier: Modifier = Modifier){
    Build_UI(modifier = Modifier.fillMaxSize())


}

@Preview(showBackground = true)
@Composable
fun Main__Preview() {
    DiceTheme {
        Main__()
    }
}