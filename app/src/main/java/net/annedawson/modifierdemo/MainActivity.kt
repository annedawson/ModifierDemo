package net.annedawson.modifierdemo

/*
Date: Saturday 26th November 2022, 14:28 PT
Programmer: Anne Dawson
Email: anne.dawson@gmail.com
App: ModifierDemo
File: MainActivity.kt
Purpose: To demonstrate the use of modifiers
From: https://www.answertopia.com/jetpack-compose/how-to-use-modifiers-in-jetpack-compose/
Status: NOT Completed
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.annedawson.modifierdemo.ui.theme.ModifierDemoTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*


// This code has been developed from the instructions here:
// https://www.answertopia.com/jetpack-compose/how-to-use-modifiers-in-jetpack-compose/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierDemoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {

    // val modifier = Modifier   assigns an empty Modifier companion object to variable modifier
    // the above modifier has no configuration settings

    // To configure the modifier, we need to call methods on it. For example,
    // the modifier can be configured to add 10dp of padding on all four sides
    // of *** any *** composable to which it is applied:

    // val modifier = Modifier.padding(all = 10.dp)

    // method calls may be chained:

    val modifier = Modifier
        .border(width = 2.dp, color = Color.Black)
        .padding(all = 10.dp)

    // try changing the order of the two lines above to see the effect
    // when the app runs. Order matters.

    // Once a modifier has been created
    // it can be passed to any composable which accepts a modifier parameter.

    //  This was the original Text composable:

    /*

    Text(
        "Hello Compose",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )


     If a built-in composable accepts a modifier
     it will always be the first optional parameter in the parameter list.

     If you create a new composable and want to pass a modifier, again
     it should always be the first optional parameter in the parameter list.

     Here we are sending a modifier to a built-in composable:

     */

    Text(
        "Hello Compose",
        modifier = modifier,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

// Here we are sending a modifier to a custom composable (not built-in).
// The modifier parameter *** has *** to have a default value (= Modifier)
// so that when this composable is called, you don't need to
// specify a modifier argument in the call, the default will be used.
// In fact, when this CustomImage composable is called from

@Composable
fun CustomImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}