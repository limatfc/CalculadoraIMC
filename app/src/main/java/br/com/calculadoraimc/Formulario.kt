package br.com.calculadoraimc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Formulario(peso: MutableState<String>, altura: MutableState<String>, resultadoImc: MutableState<Double>, statusImc: MutableState<String>){
    Column (
        modifier = Modifier.
        fillMaxWidth().
        padding(horizontal = 32.dp)
    ){
        Card(
            modifier = Modifier.
            fillMaxWidth().
            offset(y = (-28).dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            border = BorderStroke(width = 1.dp, Color.White),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column (
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp)
            ){
                Text(
                    text = "Seus dados",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "Seu peso:",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    fontSize = 16.sp,
                )
                OutlinedTextField(
                    value = peso.value,
                    onValueChange = {
                        peso.value = it
                    },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    placeholder = {
                        Text(text = "Seu peso em Kg.", color = colorResource(id = R.color.vermelho))

                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.vermelho),
                        focusedBorderColor = colorResource(id = R.color.vermelho)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                Text(text = "Sua altura",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    fontSize = 16.sp,)
                OutlinedTextField(
                    value = altura.value,
                    onValueChange = {
                        altura.value = it
                    },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    placeholder = {
                        Text(text = "Sua altura em cm.", color = colorResource(id = R.color.vermelho))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.vermelho),
                        focusedBorderColor = colorResource(id = R.color.vermelho)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                Button(
                    onClick = {
                        resultadoImc.value = calcularImc(peso = peso.value.toDouble(), altura = altura.value.toDouble())
                        statusImc.value = determinarClassificacaoIMC(resultadoImc.value)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho)),
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 16.dp)
                ) {
                    Text(text = "CALCULAR", color = Color.White)
                }
            }
        }
    }
}