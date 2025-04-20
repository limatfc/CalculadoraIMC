package br.com.calculadoraimc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header (){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.
        fillMaxWidth().
        height(160.dp).
        background(colorResource(id = R.color.vermelho))
    ){
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.`imc`),
            contentDescription = "Descricao",
            modifier = Modifier.size(60.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "CALCULADORA IMC",
            color = colorResource(id = R.color.white),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
        )
    }
}