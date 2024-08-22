package org.example.campuscrew.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.apace_app.Quiz.QuizAppPrev
import com.example.apace_app.navigation.Routes
import org.example.campuscrew.screens.BottomNav

@Composable
fun NavGraph(navController:NavHostController){

    NavHost(navController = navController , startDestination = Routes.BottomNav.routes,
        ) {

        composable(Routes.BottomNav.routes){
            BottomNav(navController)
        }

        composable(route = Routes.Quiz.routes) {
            QuizAppPrev()
        }
        composable(route = Routes.Result.routes) {
            QuizAppPrev()
        }
    }

}

enum class ScaleTransitionDirection {
    INWARDS, OUTWARDS
}

fun scaleIntoContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.INWARDS,
    initialScale: Float = if (direction == ScaleTransitionDirection.OUTWARDS) 0.9f else 1.0f
): EnterTransition {
    return scaleIn(
        animationSpec = tween(420, delayMillis = 90),
        initialScale = initialScale
    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
}

fun scaleOutOfContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.INWARDS,
    targetScale: Float = if (direction == ScaleTransitionDirection.OUTWARDS) 1.0f else 0.9f
): ExitTransition {
    return scaleOut(
        animationSpec = tween(420, delayMillis = 90),
        targetScale = targetScale
    ) + fadeOut(animationSpec = tween(220, delayMillis = 90))
}