package com.example.apace_app.Result
import androidx.activity.compose.BackHandler

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.apace_app.Quiz.AnimatedStrikeAnimation
import com.example.apace_app.R
import com.example.apace_app.common.greetview
import com.example.apace_app.common.heading
import com.example.apace_app.common.write
import com.example.apace_app.navigation.Routes


@Composable
fun ResultApp(correctAnswer: String,navHostController: NavHostController) {
    BackHandler {
        navHostController.navigate(Routes.Home.routes) {
            popUpTo(navHostController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
//        color = colorResource(id = R.color.App_Light)
    ) {
        Image(
            painter = painterResource(id = R.drawable.spacebgg), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Adjust image scaling as needed
        )

        Column {
            heading(text = "Quiz App")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
//                Image(
//                    painter = painterResource(id = R.drawable.img_3),
//                    contentDescription = "Start Image",
//                    modifier = Modifier
//                        .size(250.dp) // Adjust size as needed
//                        .clickable {
//                            // Handle image click here
//                        }
//                )
                val text = when {
                    correctAnswer.toInt() <= 5 -> "Average"
                    correctAnswer.toInt() <= 8 -> "Good"
                    else -> "Excellent"
                }
                AnimatedStrikeAnimation(5.dp,R.raw.rocket)
                greetview(text = text)
                CustomCard(correctAnswer)

                // Add more content here if needed
                // For example:
                // write("Your result goes here")
            }
        }
    }
}
@Composable
fun CustomCard(correctAnswer: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.App_Dark) // Use your desired color here
        ),
        elevation = CardDefaults.cardElevation(8.dp) // Elevation of the card
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Score :",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = correctAnswer,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
                Text(text = " /10",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }}
    }
}
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun ResultAppPrev() {
//    ResultApp("5")
//}