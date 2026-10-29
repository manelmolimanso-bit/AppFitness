package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitness.UserProfile

@Composable
fun ProfileScreen(
    userProfile: UserProfile,
    onEditClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cabecera superior: Título "Perfil" e icono de editar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Perfil",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Editar perfil",
                    tint = Color(0xFF00897B)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Avatar de perfil, nombre y correo
        ProfileAvatar(size = 110.dp, showBadge = true)

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = userProfile.nom,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = userProfile.correu,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Fila de tarjetas con datos físicos y personales
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatCard(
                label = "Edat",
                value = "${userProfile.edat} anys",
                modifier = Modifier.weight(1f)
            )
            StatCard(
                label = "Gènere",
                value = userProfile.genere,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                label = "Alçada",
                value = "${userProfile.alcada} cm",
                modifier = Modifier.weight(1f)
            )
            StatCard(
                label = "Pes",
                value = "${userProfile.pes} kg",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sección: Objectius
        SectionHeader(title = "Objectius", onEditClick = onEditClick)
        InfoCard(
            title = userProfile.objectiu,
            subtitle = "Pes objectiu: ${userProfile.pesObjectiu} kg",
            icon = Icons.Default.Star
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Sección: Nivell d'activitat
        SectionHeader(title = "Nivell d'activitat", onEditClick = onEditClick)
        InfoCard(
            title = userProfile.activitat,
            subtitle = obtenirDescripcioActivitat(userProfile.activitat),
            icon = Icons.Default.Favorite
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Sección: Informació addicional
        SectionHeader(title = "Informació addicional", onEditClick = onEditClick)
        InfoCard(
            title = "Preferències alimentàries",
            subtitle = "Dieta equilibrada / Mediterrània",
            icon = Icons.Default.Info
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Botón principal para editar perfil
        Button(
            onClick = onEditClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00897B))
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Editar perfil")
        }
    }
}

@Composable
fun SectionHeader(title: String, onEditClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = onEditClick) {
            Text(
                text = "Editar",
                color = Color(0xFF00897B),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

fun obtenirDescripcioActivitat(activitat: String): String {
    return when (activitat) {
        "Sedentari" -> "Poc o cap exercici setmanal"
        "Lleuger" -> "Exercici 1-2 vegades per setmana"
        "Moderat" -> "Exercici 3-4 vegades per setmana"
        "Actiu" -> "Exercici 5-6 vegades per setmana"
        "Molt actiu" -> "Exercici intens diari"
        else -> "Exercici regular"
    }
}