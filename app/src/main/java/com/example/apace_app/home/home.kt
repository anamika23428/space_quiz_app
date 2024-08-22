package com.example.apace_app.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apace_app.R
import com.example.apace_app.common.commonButton
import com.example.apace_app.common.heading
import com.example.apace_app.common.levelbtn

@Composable
fun Home() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.App_Light)
    ) {
        Column {
            heading(text = "Quiz App")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LevelSelectionCard()
                Spacer(modifier = Modifier.height(16.dp))

                commonButton(text = "Start") {
                    // Handle button click
                }
            }
        }
    }
}

@Composable
fun LevelSelectionCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.App_Dark) // Use your desired color here
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Choose Level :",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
             levelbtn(text = "Easy Level") {
             }
            Spacer(modifier = Modifier.height(16.dp))
            levelbtn(text = "Medium Level") {
            }
            Spacer(modifier = Modifier.height(16.dp))
            levelbtn(text = "Hard Level") {
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Additional content like buttons or descriptions can be added here
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun vieww() {
    Home()
}
