package org.example.campuscrew.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                Home(navController1, LocalContext.current)
            }
            composable(route = "${Routes.Quiz.routes}/{difficultyLevel}") { backStackEntry ->
                val difficultyLevel = backStackEntry.arguments?.getString("difficultyLevel")?.toIntOrNull() ?: 1
                QuizAppPrev(navController1, difficultyLevel)
            }
            composable(
                route = "${Routes.Result.routes}/{correctAnswers}",
                arguments = listOf(navArgument("correctAnswers") { type = NavType.IntType })
            ) { backStackEntry ->
                val correctAnswers = backStackEntry.arguments?.getInt("correctAnswers") ?: 0
                ResultApp(correctAnswers.toString(),navController1)
            }
        }


    }
}
