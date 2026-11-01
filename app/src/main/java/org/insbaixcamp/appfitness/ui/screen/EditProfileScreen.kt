package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditProfileScreen(
    nomActual: String,
    correuActual: String,
    alcadaActual: String,
    pesActual: String,
    objectiuActual: String, // No se ven en la foto, los pasamos ocultos
    activitatActual: String, // No se ven en la foto, los pasamos ocultos
    onGuardar: (String, String, String, String, String, String) -> Unit,
    onCancelar: () -> Unit
) {
    var nom by remember { mutableStateOf(nomActual) }
    var correu by remember { mutableStateOf(correuActual) }
    var alcada by remember { mutableStateOf(alcadaActual) }
    var pes by remember { mutableStateOf(pesActual) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.Start // Alineado a la izquierda como la foto
    ) {
        Text(text = "Editar perfil", fontSize = 18.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        // Cajas grises de texto, idénticas a la foto
        val textFieldColors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFF3F3F3),
            focusedContainerColor = Color(0xFFF3F3F3),
            unfocusedIndicatorColor = Color(0xFFE0E0E0),
            focusedIndicatorColor = Color(0xFF4CAF50)
        )

        TextField(
            value = nom, onValueChange = { nom = it },
            label = { Text("Nom", color = Color.Gray, fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(), colors = textFieldColors
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = correu, onValueChange = { correu = it },
            label = { Text("Correu", color = Color.Gray, fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(), colors = textFieldColors
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = alcada, onValueChange = { alcada = it },
            label = { Text("Alçada", color = Color.Gray, fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(), colors = textFieldColors
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = pes, onValueChange = { pes = it },
            label = { Text("Pes", color = Color.Gray, fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(), colors = textFieldColors
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón Guardar verde claro
        Button(
            onClick = { onGuardar(nom, correu, alcada, pes, objectiuActual, activitatActual) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE0F2F1), // Verde muy pálido
                contentColor = Color(0xFF2E7D32)    // Texto verde oscuro
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text("Guardar canvis", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.weight(1f)) // Empuja hacia abajo

        // Texto que hace de botón de Cancelar
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCancelar() }
                .padding(16.dp)
        ) {
            Text(text = "EditProfileScreen", fontSize = 18.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Modificar les dades", fontSize = 16.sp, color = Color.Gray)
        }
    }
}