package com.example.apace_app.Quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.apace_app.R
import com.example.apace_app.common.Options
import com.example.apace_app.common.commonButton
import com.example.apace_app.common.head
import com.example.apace_app.common.heading
import com.example.apace_app.common.question
import com.example.apace_app.common.write
import kotlinx.coroutines.delay


@Composable
fun QuizApp(questionList: List<Question>) {
    // Remember the current question index state
    val currentIndex = remember { mutableStateOf(0) }
    // State to remember the selected option
    val selectedOption = remember { mutableStateOf<String?>(null) }

    // Get the current question based on the index
    val currentQuestion = questionList[currentIndex.value]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.App_Light))
    ) {
        heading(text = "Space Quiz")

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            head(text = "Question ${currentIndex.value + 1}")
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            question(currentQuestion.questionText)
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(currentQuestion.options.size) { index ->
                    val optionText = currentQuestion.options[index]
                    Options(
                        text = optionText,
                        isSelected = selectedOption.value == optionText,
                        onClick = {
                            selectedOption.value = optionText
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.Bottom
        ) {
            commonButton(text = "Next") {
                // Update the current question index
                if (currentIndex.value < questionList.size - 1) {
                    currentIndex.value++
                    selectedOption.value = null // Reset the selected option for the next question
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun QuizAppPrev() {
    QuizApp(sampleQuestions)
    }

@Composable
fun AnimatedStrikeAnimation(animationOffset: Dp) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.rocket))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)

    Box(modifier = Modifier) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier
                .offset(y = animationOffset) // Move animation based on offset
                .size(100.dp) // Adjust size as needed
                .align(Alignment.BottomCenter) // Align as needed
        )
    }
}








@Composable
fun MainScreen() {
    var offset by remember { mutableStateOf(0.dp) }
    var isAnimating by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {

        AnimatedStrikeAnimation(animationOffset = offset)

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                if (!isAnimating) {
                    isAnimating = true

                }
            }) {
                Text("Animate Upward")
            }

                if(isAnimating){
                    LaunchedEffect(Unit) {
                        // Example of upward movement
                        for (i in 0..1000) {
                            offset = (50.dp - i.dp).coerceAtLeast(0.dp)
                            delay(20) // Adjust speed of movement
                        }
                        isAnimating = false
                    }
                }
            }


    }
}


