package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Componente para el avatar (el circulito de arriba en el perfil)
@Composable
fun AvatarPerfil(){
    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape) // Lo recorto en forma de círculo
            .background(Color.Gray), // Fondo gris
        contentAlignment = Alignment.Center // Centro lo que haya dentro
    ) {
        // Le pongo un emoji temporal para que no se vea vacío
        Text(text = "👤", fontSize = 40.sp)
    }
}

// Molde para las tarjetas de datos (así no tengo que repetir el código 4 veces)
@Composable
fun TargetaDada(titol: String, valor: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título arriba (ej: Alçada) y el valor abajo en negrita
            Text(text = titol)
            Text(text = valor, fontWeight = FontWeight.Bold)
        }
    }
}

// Menú desplegable para poder elegir el Objetivo y la Actividad al editar
@Composable
fun SelectorDesplegable(
    etiqueta: String,
    valorSeleccionat: String,
    opcions: List<String>,       // Lista con las opciones que saldrán
    onValorCanviat: (String) -> Unit
) {
    // Estado para controlar si el menú está abierto o cerrado
    var desplegat by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {

        OutlinedTextField(
            value = valorSeleccionat,
            onValueChange = {},
            readOnly = true, // Lo pongo en readOnly para que no salga el teclado del móvil
            label = { Text(etiqueta) },
            modifier = Modifier.fillMaxWidth()
        )

        // Capa transparente encima del textfield para pillar el clic y abrir el menú
        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { desplegat = true }
        )

        // El desplegable en sí
        DropdownMenu(
            expanded = desplegat,
            onDismissRequest = { desplegat = false } // Si toco fuera, lo cierro
        ) {
            // Recorro la lista de opciones y pinto un botón por cada una
            opcions.forEach { opcio ->
                DropdownMenuItem(
                    text = { Text(opcio) },
                    onClick = {
                        onValorCanviat(opcio) // Guardo la opción que han tocado
                        desplegat = false     // Cierro el desplegable
                    }
                )
            }
        }
    }
}