package br.com.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    IMCScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun IMCScreen(modifier: Modifier) {
    var peso = remember { mutableStateOf("") }
    var altura = remember { mutableStateOf("") }
    var resultadoImc = remember { mutableStateOf(0.0) }
    var statusImc = remember { mutableStateOf("") }

   Box(
       modifier = Modifier.fillMaxSize()
   ){
       Column( modifier = Modifier.fillMaxSize()) {
           Header()
           Formulario(peso, altura, resultadoImc, statusImc)
           Resultado(peso, altura, resultadoImc, statusImc)
       }
   }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CalculadoraIMCTheme {
        IMCScreen(modifier = Modifier)
    }
}