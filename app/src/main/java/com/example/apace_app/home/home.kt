package com.example.apace_app.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apace_app.R
import com.example.apace_app.common.commonButton
import com.example.apace_app.common.heading


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
                Spacer(modifier = Modifier.height(16.dp))
//            Heading2(text = "Choose Difficulty")

                Spacer(modifier = Modifier.height(24.dp))

                DifficultyOption(text = "Easy")
                DifficultyOption(text = "Medium")
                DifficultyOption(text = "Hard")

                Spacer(modifier = Modifier.height(32.dp))

                commonButton(text = "Start") {
                    // Handle button click
                }
            }
        }
    }
}

@Composable
fun DifficultyOption(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = colorResource(id = R.color.Highlight),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable

fun vieww(){
    Home()
}