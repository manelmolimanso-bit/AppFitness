package org.insbaixcamp.appfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.insbaixcamp.appfitness.ui.screen.EditProfileScreen
import org.insbaixcamp.appfitness.ui.screen.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FitnessApp()
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var estemEditant by remember { mutableStateOf(false) }

    var nomOficial by remember { mutableStateOf("Laia Soler") }
    var correuOficial by remember { mutableStateOf("laia.soler@exemple.com") }
    var alcadaOficial by remember { mutableStateOf("165") }
    var pesOficial by remember { mutableStateOf("60") }
    var objectiuOficial by remember { mutableStateOf("Salut") }
    var activitatOficial by remember { mutableStateOf("Moderat") }

    if (!estemEditant) {
        ProfileScreen(
            nom = nomOficial,
            correu = correuOficial,
            alcada = alcadaOficial,
            pes = pesOficial,
            objectiu = objectiuOficial,
            activitat = activitatOficial,
            onEditarClick = { estemEditant = true }
        )
    } else {
        EditProfileScreen(
            nomActual = nomOficial,
            correuActual = correuOficial,
            alcadaActual = alcadaOficial,
            pesActual = pesOficial,
            objectiuActual = objectiuOficial,
            activitatActual = activitatOficial,
            onGuardar = { nouNom, nouCorreu, novaAlcada, nouPes, nouObjectiu, novaActivitat ->
                nomOficial = nouNom
                correuOficial = nouCorreu
                alcadaOficial = novaAlcada
                pesOficial = nouPes
                objectiuOficial = nouObjectiu
                activitatOficial = novaActivitat
                estemEditant = false
            },
            onCancelar = {
                estemEditant = false
            }
        )
    }
}