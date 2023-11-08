package com.jotap.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.jotap.weatherapp.ui.theme.WeatherAppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    page()
                }
            }
        }
    }
}

var informacaoSeteDias = listOf (
    temperaturaDia(
        temperatura = 15,
        estado = "Nublado",
        resource = R.drawable.cloudy
    ),
    temperaturaDia(
        temperatura = 10,
        estado = "Tempest.",
        resource = R.drawable.storm
    ),
    temperaturaDia(
        temperatura = 0-1,
        estado = "Neve",
        resource = R.drawable.snowy
    ),
    temperaturaDia(
        temperatura = 35,
        estado = "Limpo",
        resource = R.drawable.sun
    ),
    temperaturaDia(
        temperatura = 25,
        estado = "Limpo",
        resource = R.drawable.sun
    ),
    temperaturaDia(
        temperatura = 25,
        estado = "Limpo",
        resource = R.drawable.sun
    ),
    temperaturaDia(
        temperatura = 25,
        estado = "Limpo",
        resource = R.drawable.sun
    )

)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true, heightDp = 800, widthDp = 380)
@Composable
fun page(): Unit {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Cabecalho()
        dataNome("João")
        centralImage()
        proximosSeteDias()

    }
}

//@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun centralImage(): Unit {
    Box(
        modifier = Modifier
            .height(300.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
            Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(320.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sun),
                        contentDescription = "Sol",
                        modifier = Modifier
                            .size(300.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 230.dp, 0.dp, 0.dp),
            ) {
                Text(
                    text = "12ºC",
                    fontWeight = FontWeight.Light,
                    fontSize = TextUnit(18f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = " Nublado",
                    fontWeight = FontWeight.Light,
                    fontSize = TextUnit(18f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.secondary
                )

            }
    }
}

// @Preview(showBackground = true, heightDp = 50, widthDp = 380)
@Composable
fun Cabecalho(): Unit {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .fillMaxWidth()
    ) {

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            modifier = Modifier.size(35.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = R.string.Menu_search.toString()
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.eu),
                contentDescription = R.string.Menu_foto.toString()
            )


        }
    }
}

// @Preview(showBackground = true, widthDp = 380)
@Composable
fun dataNome(name: String = "João"): Unit {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Olá",
                modifier = Modifier.padding(end = 2.dp),
                fontSize = TextUnit(25f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary

            )
            Text(
                text = "$name",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(25f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary
            )

        }
        Text(
            text = formatData(Calendar.getInstance().time),
            fontWeight = FontWeight.Light,
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Alenquer",
            fontWeight = FontWeight.Light,
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

//@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun CorpoTopo() {

    Column {

        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, contentColor = Color.DarkGray
            ), modifier = Modifier.padding(0.dp)/*.then
            (Modifier.border(width = 0.dp))*/
        ) {
            Text(text = "JotaP")
        }
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, contentColor = Color.DarkGray
            ), modifier = Modifier.padding(0.dp)
        ) {
            Text(text = "Quarta, 01 Novembro 2023")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            /*contentPadding = PaddingValues()
            modifier = Modifier.padding(100.dp,100.dp)*/

        ) {

            Image(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = R.string.tempoAtual.toString(),
                contentScale = ContentScale.Fit/*modifier = Modifier.align(Alignment.Vertical)*/

            )
        }
    }
}

fun formatData(data: Date): String {
    val format = SimpleDateFormat("dd MMMM, EEEE yyyy", Locale("pt", "PT"))
    return format.format(data)
}

@Preview(showBackground = true, widthDp = 380)
@Composable
fun proximosSeteDias(): Unit{
    LazyRow {
        items(informacaoSeteDias){
            proximoDia (it)
        }
    }
}


@Composable
fun proximoDia(temperaturaDia: temperaturaDia): Unit {
    Column (
        modifier = Modifier
            .width(100.dp)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        )
        {
        Image(painter = painterResource(id = temperaturaDia.resource),
            contentDescription = temperaturaDia.estado)
            Text(text =temperaturaDia.temperatura.toString())
            Text(text =temperaturaDia.estado)
        }
 }
