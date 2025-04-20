package br.com.calculadoraimc

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Resultado(peso: MutableState<String>, altura: MutableState<String>, resultadoImc: MutableState<Double>, statusImc: MutableState<String>){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card (
        modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 24.dp).height(200.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.verde)
        )
    )
    {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(32.dp).height(200.dp)
        ){
            Column (
               modifier = Modifier.width(200.dp)
            ){
                Text(text = "Resultado",
                    color = Color.White,
                    fontSize = 14.sp)
                Text(text = "${statusImc.value}",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
            }
            Text(text = "${String.format("%.1f", resultadoImc.value)}",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
        Button(
            onClick = {
            peso.value = ""
            altura.value = ""
            resultadoImc.value = 0.0
        },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.white)),
            modifier = Modifier.width(250.dp).height(60.dp).padding(top = 16.dp).
            border(
                width = 2.dp,
                color = colorResource(id = R.color.vermelho),
                shape = RoundedCornerShape(8.dp)
            ),
        ) {
            Text(text="Limpar", color = colorResource(id = R.color.vermelho))
        }
    }
}