package com.example.apace_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.apace_app.Quiz.QuizAppPrev
import org.example.campuscrew.screens.BottomNav


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNav(navController = rememberNavController())
        }
    }
}

