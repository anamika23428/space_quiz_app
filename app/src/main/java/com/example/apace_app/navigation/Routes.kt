package com.example.apace_app.navigation

sealed class Routes(val routes: String) {

    object Home : Routes("Home")
    object Quiz : Routes("quiz")
    object Result : Routes("result")
    object BottomNav : Routes("BottomNav")

}