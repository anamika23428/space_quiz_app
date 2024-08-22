package com.example.apace_app.common

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
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
            .padding(8.dp)
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
fun options(text:String){

}
@Composable
fun write(text: String = "IIT Mandi keeps the health and wellness") {

    Text(
        textAlign = TextAlign.Left,
        text = text, fontFamily = robotoregular,
        fontSize = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 10.dp)
            .fillMaxWidth()
    )
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