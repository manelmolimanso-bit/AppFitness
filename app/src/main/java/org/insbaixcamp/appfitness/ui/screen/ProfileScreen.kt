package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    nom: String,
    correu: String,
    alcada: String,
    pes: String,
    objectiu: String,
    activitat: String,
    onEditarClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        AvatarPerfil()

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = nom, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = correu, fontSize = 12.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        // La línea divisoria sutil que sale en la imagen
        Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            TargetaDada(titol = "Alçada", valor = "$alcada cm", modifier = Modifier.weight(1f))
            TargetaDada(titol = "Pes", valor = "$pes kg", modifier = Modifier.weight(1f))
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            TargetaDada(titol = "Objectiu", valor = objectiu, modifier = Modifier.weight(1f))
            TargetaDada(titol = "Activitat", valor = activitat, modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.weight(1f)) // Empuja el texto hacia abajo

        // Este bloque de texto funciona como botón para ir a Editar
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { onEditarClick() }
                .padding(16.dp)
        ) {
            Text(text = "ProfileScreen", fontSize = 18.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Consultar les dades", fontSize = 16.sp, color = Color.Gray)
        }
    }
}