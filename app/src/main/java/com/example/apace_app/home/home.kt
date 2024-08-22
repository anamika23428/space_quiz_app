package com.example.apace_app.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.apace_app.Quiz.AnimatedStrikeAnimation
import com.example.apace_app.R
import com.example.apace_app.common.LevelBtn
import com.example.apace_app.common.heading
import com.example.apace_app.common.toast
import com.example.apace_app.navigation.Routes

@Composable
fun Home(navHostController: NavHostController,context: Context) {
    val viewModel: ButtonStateViewModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.App_Light)
    ) {
        Column {
            heading(text = "SpaceQuest")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.img),
//                    contentDescription = "Start Image",
//                    modifier = Modifier
//                        .size(150.dp)
//                        .clickable {
//                            // Handle image click here
//                        }
//                )
                AnimatedStrikeAnimation(animationOffset = 5.dp, animationRes = R.raw.solar)

                LevelSelectionCard(viewModel)

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.start_btn),
                    contentDescription = "Start Image",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable {
                            // Navigate to the Quiz screen with the selected difficulty level
                            if (viewModel.clickedButton == -1)
                                toast(context = context, "Please Select Level")
                            else {
                                val selectedLevel = viewModel.clickedButton

                                navHostController.navigate("${Routes.Quiz.routes}/$selectedLevel")
                            }
                        }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun show(){
    Home(navHostController = rememberNavController(), LocalContext.current)
}
@Composable
fun LevelSelectionCard(viewModel: ButtonStateViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.App_Dark) // Use your desired color here
        ),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Choose Level:",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            LevelBtn(
                id = 1,
                text = "Easy Level",
                viewModel = viewModel,
                onClick = {
                    // Handle click for Level 1
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            LevelBtn(
                id = 2,
                text = "Medium Level",
                viewModel = viewModel,
                onClick = {
                    // Handle click for Level 2
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            LevelBtn(
                id = 3,
                text = "Hard Level",
                viewModel = viewModel,
                onClick = {
                    // Handle click for Level 1
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

class ButtonStateViewModel : ViewModel() {
    // State to keep track of the currently clicked button
    var clickedButton by mutableStateOf(-1)
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewHome() {
//    Home()
//}