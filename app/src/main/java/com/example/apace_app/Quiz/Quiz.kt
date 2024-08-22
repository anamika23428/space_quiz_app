package com.example.apace_app.Quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apace_app.R
import com.example.apace_app.common.heading
import com.example.apace_app.common.write


@Composable
fun QuizApp(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.App_Primary))
    ) {
        heading(text = "Quiz")


        Column {
            write("Which is the first Planet of Solar System?")
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun QuizAppPrev(){
    QuizApp()
}