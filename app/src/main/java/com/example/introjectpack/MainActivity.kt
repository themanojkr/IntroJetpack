package com.example.introjectpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introjectpack.ui.theme.IntroJectpackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroJectpackTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
                }
            }
        }
    @Preview(showBackground = true, device = Devices.PIXEL_2_XL)
    @Composable
    fun MyApp(){
        var count by remember {
            mutableIntStateOf(0)
            // hello
        }
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {

            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "$ $count", fontSize = 40.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(100.dp))
                Circle(count) {
                    count = it
                }
            }

        }
    }

    @Composable
    private fun Circle(count: Int , CountMoney:(Int) ->Unit) {
      var countMoney = count
        Box(
            Modifier
                .width(100.dp)
                .height(100.dp)
                .clickable {
                    countMoney = count?.plus(1)!!
                    CountMoney(countMoney)
                    Log.d("Manoj", "Circle: Tab Clicked")
                }
                .background(Color.Green, shape = CircleShape), contentAlignment = Alignment.Center) {
//            Text(text = "Tap",color= Color.White)
            setText(txt = "Tap")
        }
    }


    @Composable
    fun setText(txt:String){
        Text(text = txt,color= Color.White, fontSize = 30.sp)
    }
    }



