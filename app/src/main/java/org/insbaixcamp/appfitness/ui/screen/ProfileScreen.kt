package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Pantalla principal donde solo muestro los datos, sin editarlos
@Composable
fun ProfileScreen(
    nom: String,
    correu: String,
    alcada: String,
    pes: String,
    objectiu: String,
    activitat: String,
    onEditarClick: () -> Unit // Función que llamaré cuando pulsen el botón de editar
) {
    // Uso un Column para poner tot de arriba a abajo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centro tot horizontalmente
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // 1. Pongo el avatar que creé en ComponentsPerfil
        AvatarPerfil()

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Textos para el nombre y el correo
        Text(text = nom, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = correu, fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        // 3. Fila 1: Altura y Peso (Uso mis TargetaDada)
        Row(modifier = Modifier.fillMaxWidth()) {
            // Le pongo weight(1f) a cada una para que ocupen exactamente la mitad de la fila (50%)
            TargetaDada(
                titol = "Alçada",
                valor = "$alcada cm",
                modifier = Modifier.weight(1f)
            )
            TargetaDada(
                titol = "Pes",
                valor = "$pes kg",
                modifier = Modifier.weight(1f)
            )
        }

        // 4. Fila 2: Objetivo y Actividad
        Row(modifier = Modifier.fillMaxWidth()) {
            TargetaDada(
                titol = "Objectiu",
                valor = objectiu,
                modifier = Modifier.weight(1f)
            )
            TargetaDada(
                titol = "Activitat",
                valor = activitat,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // 5. Botón para ir a la pantalla de edición
        Button(
            onClick = onEditarClick, // Lanzo la acción que me pasan por parámetro
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Editar perfil", fontSize = 18.sp)
        }
    }
}