package org.insbaixcamp.appfitness
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.insbaixcamp.appfitness.ui.screen.EditProfileScreen
import org.insbaixcamp.appfitness.ui.screen.ProfileScreen
import org.insbaixcamp.appfitness.ui.theme.AppFitnessTheme

// Modelo de datos con los valores iniciales de Laia Soler
data class UserProfile(
    val nom: String = "Laia Soler",
    val correu: String = "laia.soler@exemple.com",
    val edat: String = "29",
    val dataNaixement: String = "15/03/1995",
    val genere: String = "Dona",
    val alcada: String = "165",
    val pes: String = "60",
    val pesObjectiu: String = "58",
    val objectiu: String = "Guanyar massa muscular",
    val activitat: String = "Moderat"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var userProfile by remember { mutableStateOf(UserProfile()) }
    var isEditing by remember { mutableStateOf(false) }

    if (isEditing) {
        EditProfileScreen(
            userProfile = userProfile,
            onSave = { updatedProfile ->
                userProfile = updatedProfile
                isEditing = false
            },
            onCancel = {
                isEditing = false
            }
        )
    } else {
        ProfileScreen(
            userProfile = userProfile,
            onEditClick = {
                isEditing = true
            }
        )
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FitnessAppPreview() {
    AppFitnessTheme {
        FitnessApp()
    }
}