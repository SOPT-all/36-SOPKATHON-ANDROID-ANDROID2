package org.sopt.sopkathon.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SOPKATHONTheme {
                MainScreen()
            }
        }
    }
}
