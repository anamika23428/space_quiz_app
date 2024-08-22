package com.example.apace_app.common

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apace_app.R
import com.example.apace_app.home.ButtonStateViewModel
import com.example.apace_app.robotomedium
import com.example.apace_app.robotoregular

@Composable
fun commonButton(
    text: String,
    elevation: Dp = 4.dp,
    pressedElevation: Dp = 2.dp, onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val currentElevation by animateDpAsState(
        if (isPressed) pressedElevation else elevation
    )

    val scale by animateFloatAsState(if (isPressed) 0.95f else 1f)

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.Highlight),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = currentElevation
        ),
        modifier = Modifier
            .padding(16.dp)
            .scale(scale)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun LevelBtn(
    id: Int,
    text: String,
    elevation: Dp = 12.dp,
    pressedElevation: Dp = 2.dp,
    onClick: () -> Unit,
    viewModel: ButtonStateViewModel
) {
    val isClicked by remember { derivedStateOf { viewModel.clickedButton == id } }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val onClickInternal: () -> Unit = {
        onClick()
        viewModel.clickedButton = id
    }

    val currentElevation by animateDpAsState(
        if (isPressed) pressedElevation else elevation
    )

    val scale by animateFloatAsState(if (isPressed) 0.95f else 1f)

    Button(
        onClick = onClickInternal,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isClicked) colorResource(id = R.color.Yello_Secondary) else colorResource(id = R.color.Highlight),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = currentElevation
        ),
        modifier = Modifier
            .padding(1.dp)
            .scale(scale)
            .width(200.dp)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(4.dp)
        )
    }
}
@Composable
fun MutableInteractionSource.collectIsPressedAsState(): State<Boolean> {
    val isPressed = rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(this) {
        interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> isPressed.value = true
                is PressInteraction.Release, is PressInteraction.Cancel -> isPressed.value = false
            }
        }
    }
    return isPressed
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun showall() {
    Column {
        commonButton(text = "START") {

        }
        heading(text = "Heading")
        heading2(text = "Heading")
        write("First planet of Solar System")


    }

}


@Composable
fun write(text: String = "IIT Mandi keeps the health and wellness") {

    Text(
        textAlign = TextAlign.Center,
        text = text, fontFamily = robotomedium,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        color = colorResource(id = R.color.App_Primary),
        modifier = Modifier
            .padding(16.dp)
    )
}
@Composable
fun writer(text: String = "IIT Mandi keeps the health and wellness",isSelected: Boolean) {

    Text(
        textAlign = TextAlign.Center,
        text = text, fontFamily = robotomedium,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        color = if(!isSelected) colorResource(id = R.color.App_Dark) else Color.White,
        modifier = Modifier
            .padding(16.dp)
    )
}

        @Composable
fun head(text: String = "Question") {

    Text(
        textAlign = TextAlign.Center,
        text = text, fontFamily = robotomedium,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 10.dp)
    )
}
@Composable
fun question(text:String){
    Surface(tonalElevation = 8.dp,
        border = BorderStroke(1.dp, color = colorResource(id = R.color.Highlight)),

        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
        ,
        color = Color.White
    ) {

        write(text)
    }
}
@Composable
fun heading(text: String) {
    Surface(
        color = colorResource(id = R.color.App_Primary),
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 4.dp,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){


            Text(
                textAlign = TextAlign.Center,
                text = text, fontFamily = robotomedium,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 10.dp)
                    .fillMaxWidth()
            )
        }
    }
}
@Composable
fun Options(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    backgroundColor: Color = Color.White
) {
    Surface(
        border = BorderStroke(1.dp, color = colorResource(id = R.color.Highlight)),
        tonalElevation = 12.dp,
        shadowElevation = 12.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
//            .background(backgroundColor)
            .clickable(enabled = !isSelected) { onClick() }, // Disable click if already selected
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            writer(text = text,isSelected)
        }
    }
}



@Composable
fun heading2(text: String) {
    Surface(
        color = colorResource(id = R.color.grey_400),
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 4.dp,
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = text, fontFamily = robotomedium,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.App_Primary),
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 10.dp)
                .fillMaxWidth()
        )
    }
}

fun toast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun greetview(
    text: String,
    fontSize: Int = 16,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 60.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(4.dp)
    )
}
@Composable
fun wcommonButton(
    text: String,
    elevation: Dp = 4.dp,
    pressedElevation: Dp = 2.dp, onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val currentElevation by animateDpAsState(
        if (isPressed) pressedElevation else elevation
    )

    val scale by animateFloatAsState(if (isPressed) 0.95f else 1f)

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.App_Primary),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = currentElevation
        ),
        modifier = Modifier
            .padding(8.dp)
            .scale(scale)
            .wrapContentWidth()
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(4.dp)
        )
    }
}