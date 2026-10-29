package org.insbaixcamp.appfitness.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitness.UserProfile

@Composable
fun EditProfileScreen(
    userProfile: UserProfile,
    onSave: (UserProfile) -> Unit,
    onCancel: () -> Unit
) {
    // Estados locales con remember para no alterar los datos originales hasta pulsar "Guardar canvis"
    var nom by remember { mutableStateOf(userProfile.nom) }
    var correu by remember { mutableStateOf(userProfile.correu) }
    var edat by remember { mutableStateOf(userProfile.edat) }
    var dataNaixement by remember { mutableStateOf(userProfile.dataNaixement) }
    var genere by remember { mutableStateOf(userProfile.genere) }
    var alcada by remember { mutableStateOf(userProfile.alcada) }
    var pes by remember { mutableStateOf(userProfile.pes) }
    var pesObjectiu by remember { mutableStateOf(userProfile.pesObjectiu) }
    var objectiu by remember { mutableStateOf(userProfile.objectiu) }
    var activitat by remember { mutableStateOf(userProfile.activitat) }

    val opcionsGenere = listOf("Dona", "Home", "No binari", "Prefereixo no dir-ho")
    val opcionsObjectiu = listOf(
        "Guanyar massa muscular",
        "Perdre pes",
        "Millorar la salut",
        "Mantenir el pes",
        "Guanyar resistència"
    )
    val opcionsActivitat = listOf("Sedentari", "Lleuger", "Moderat", "Actiu", "Molt actiu")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Barra superior con botón de volver/cancelar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onCancel) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Tornar enrere"
                )
            }
            Text(
                text = "Editar perfil",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Foto de perfil
        Text(
            text = "Foto de perfil",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileAvatar(size = 85.dp, showBadge = false)
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                FilledTonalButton(
                    onClick = { /* Simulado en fase 1 */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(0xFFE0F2F1),
                        contentColor = Color(0xFF00796B)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Canviar foto")
                }
                Spacer(modifier = Modifier.height(6.dp))
                FilledTonalButton(
                    onClick = { /* Simulado en fase 1 */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(0xFFFFEBEE),
                        contentColor = Color(0xFFD32F2F)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Eliminar foto")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sección: Dades personals
        Text(
            text = "Dades personals",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom complet") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = correu,
            onValueChange = { correu = it },
            label = { Text("Correu electrònic") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = dataNaixement,
                onValueChange = { dataNaixement = it },
                label = { Text("Data de naixement") },
                modifier = Modifier.weight(1.5f),
                singleLine = true
            )
            OutlinedTextField(
                value = edat,
                onValueChange = { edat = it },
                label = { Text("Edat") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        DropdownSelector(
            label = "Gènere",
            options = opcionsGenere,
            selectedOption = genere,
            onOptionSelected = { genere = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sección: Dades físiques
        Text(
            text = "Dades físiques",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = alcada,
                onValueChange = { alcada = it },
                label = { Text("Alçada (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = pes,
                onValueChange = { pes = it },
                label = { Text("Pes (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = pesObjectiu,
                onValueChange = { pesObjectiu = it },
                label = { Text("Objectiu (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sección: Objectiu principal
        Text(
            text = "Objectiu principal",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        DropdownSelector(
            label = "Selecciona el teu objectiu",
            options = opcionsObjectiu,
            selectedOption = objectiu,
            onOptionSelected = { objectiu = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sección: Nivell d'activitat
        Text(
            text = "Nivell d'activitat",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        DropdownSelector(
            label = "Selecciona el teu nivell d'activitat",
            options = opcionsActivitat,
            selectedOption = activitat,
            onOptionSelected = { activitat = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botones de Guardar y Cancelar
        Button(
            onClick = {
                onSave(
                    userProfile.copy(
                        nom = nom,
                        correu = correu,
                        edat = edat,
                        dataNaixement = dataNaixement,
                        genere = genere,
                        alcada = alcada,
                        pes = pes,
                        pesObjectiu = pesObjectiu,
                        objectiu = objectiu,
                        activitat = activitat
                    )
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00897B))
        ) {
            Text("Guardar canvis")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel·lar", color = Color.Gray)
        }
    }
}