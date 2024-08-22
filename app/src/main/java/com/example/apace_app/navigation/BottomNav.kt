package org.example.campuscrew.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apace_app.Quiz.QuizAppPrev
import com.example.apace_app.Result.ResultApp
import com.example.apace_app.home.Home
import com.example.apace_app.navigation.Routes

@Composable
fun BottomNav(navController: NavHostController) {

    val navController1 = rememberNavController()

    Scaffold() {
        innerPadding ->
        NavHost(
            navController = navController1,
            startDestination = Routes.Home.routes,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Routes.Home.routes) {
                Home(navController1)
            }
            composable(route = Routes.Quiz.routes) {
                QuizAppPrev(navController1)
            }
            composable(route = Routes.Result.routes) {
                ResultApp()
            }


        }

    }
}
