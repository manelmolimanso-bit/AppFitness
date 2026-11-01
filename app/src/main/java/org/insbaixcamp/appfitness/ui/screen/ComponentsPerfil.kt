package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AvatarPerfil() {
    // Icono de silueta verde sin fondo, tal como sale en la foto
    Icon(
        imageVector = Icons.Outlined.Person,
        contentDescription = "Avatar",
        tint = Color(0xFF1E88E5).copy(green = 0.6f, red = 0.1f, blue = 0.3f), // Tono verde oscuro
        modifier = Modifier.size(64.dp)
    )
}

@Composable
fun TargetaDada(titol: String, valor: String, modifier: Modifier = Modifier) {
    // Tarjetas grises claras sin bordes
    Card(
        modifier = modifier.padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F3F3)),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = titol, fontSize = 16.sp, color = Color.DarkGray)
            Text(text = valor, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.Black)
        }
    }
}