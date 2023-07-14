package com.example.newcompose

import android.graphics.Paint.Style
import android.os.Bundle
import android.view.Gravity
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newcompose.ui.theme.NewcomposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontfamily = FontFamily(
            Font(R.font.spidy, FontWeight.Bold),
        Font(R.font.spidy,FontWeight.Light)
            )
        setContent {
            NewcomposeTheme {
            
                // A surface container using the 'background' color from the theme

val color = remember{
    mutableStateOf(Color.Yellow)
}
         LazyColumn(){
            items(90){val painte =    painterResource(id = R.drawable.spidy)
                val description = "Spider Man "
                val title =  "Spider Man"



                Imagecard(tile = title, contentDescription = description, painter = painte)


             }
         }

               LazyColumn(
                   modifier = Modifier
                       .fillMaxHeight()
                       .fillMaxWidth()
                       .border(2.dp, color = Color.Blue)
                       .offset(0.dp, 400.dp)
                       .background(color.value)
                       .clickable {
                           color.value = Color(
                               Random.nextFloat(),
                               Random.nextFloat(),
                               Random.nextFloat(), 1f
                           )

                       }
                   ,


                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Top

               ) {
                   items(50) {
                       Text(
                           text = buildAnnotatedString {
                               withStyle(
                                   style = SpanStyle(
                                       color = Color.White,
                                       fontSize = 50.sp,
                                       fontWeight = FontWeight.Bold,
                                       fontFamily = fontfamily
                                   )

                               ) {
                                   append("S")

                               }
                               append("pidy")
                           }, color = Color.White,
                           fontSize = 30.sp, fontWeight = FontWeight.Light, fontFamily = fontfamily
                       )

                       Text(
                           text = buildAnnotatedString {
                               withStyle(
                                   style = SpanStyle(
                                       color = Color.White,
                                       fontSize = 50.sp,
                                       fontWeight = FontWeight.Bold,
                                       fontFamily = fontfamily
                                   )

                               ) {
                                   append("C")

                               }
                               append("olors")
                           }, color = Color.White,
                           fontSize = 30.sp, fontWeight = FontWeight.Light, fontFamily = fontfamily
                       )
                   }
               }

                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!"
        ,

        modifier = modifier
    )

}
@Composable
fun Imagecard(
    tile: String,
    contentDescription: String,
    painter : Painter,
modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .fillMaxWidth(),

        shape = RoundedCornerShape(15.dp)

    ) {
        Box(modifier = Modifier.height(400.dp)){
            Image(painter = painter ,contentDescription = contentDescription, contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent, Color.Black
                        ),
                        startY = 300f
                    )
                )


        ){
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
                ){
                    Text(text = tile, style = TextStyle(color = Color.Red,
                        fontSize = 50.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.spidy))
                    ))
                }

            }
        }
    }
}

