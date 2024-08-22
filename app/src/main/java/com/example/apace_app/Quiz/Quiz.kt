package com.example.apace_app.Quiz

import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
import com.example.apace_app.navigation.Routes
import kotlinx.coroutines.delay



@Composable
fun QuizApp(
    questionList: List<Question>,
    navHostController: NavHostController,
    difficultyLevel: Int
) {
    var buttontext = remember { mutableStateOf("Next") }
    val currentIndex = remember { mutableStateOf(0) }
    val selectedOption = remember { mutableStateOf<String?>(null) }
    val correctAnswers = remember { mutableStateOf(0) }
    val isOptionCorrect = remember { mutableStateOf<Boolean?>(null) }  // Track if the selected option is correct or not

    val currentQuestion = questionList[currentIndex.value]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.App_Light))
    ) {
        heading(text = "Space Quiz - Level $difficultyLevel")

        Box {
            Image(
                painter = painterResource(id = R.drawable.bg), // Replace with your image resource
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Adjust image scaling as needed
            )
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
                        val isSelected = selectedOption.value == optionText
                        val isCorrect = optionText == currentQuestion.correctAnswer
                        val backgroundColor = when {
                            selectedOption.value != null -> when {
                                isSelected && isOptionCorrect.value == false -> Color.Red
                                isCorrect -> Color.Green
                                else -> Color.White
                            }
                            else -> Color.White
                        }

                        Options(
                            text = optionText,
                            isSelected = isSelected,
                            onClick = {
                                if (selectedOption.value == null) {
                                    selectedOption.value = optionText
                                    isOptionCorrect.value =
                                        optionText == currentQuestion.correctAnswer
                                }
                            },
                            backgroundColor = backgroundColor
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(24.dp))
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                commonButton(text = buttontext.value) {
                    if (selectedOption.value == currentQuestion.correctAnswer) {
                        correctAnswers.value++
                    }
                    if (currentIndex.value == questionList.size - 2) {
                        buttontext.value = "Finish"
                    }

                    if (currentIndex.value < questionList.size - 1) {
                        currentIndex.value++
                        selectedOption.value = null
                        isOptionCorrect.value = null
                    } else {
                        navHostController.navigate("${Routes.Result.routes}/${correctAnswers.value}")
                    }
                }

            }
        }
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
fun QuizAppPrev(
    navController1: NavHostController = rememberNavController(),
    difficultyLevel: Int = 1 // This is the additional integer parameter (1 to 3)
) {
    QuizApp(sampleQuestions, navController1, difficultyLevel)
}


@Composable
fun AnimatedStrikeAnimation(animationOffset: Dp, @RawRes animationRes: Int,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box(modifier = Modifier) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier
                .offset(y = animationOffset) // Move animation based on offset
                .size(240.dp) // Adjust size as needed
                .align(Alignment.BottomCenter) // Align as needed
        )
    }
}







