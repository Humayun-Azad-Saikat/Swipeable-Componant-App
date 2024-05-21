package com.example.swipeablecomponent

import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun Swipable(){

    val context = LocalContext.current

    val edit = SwipeAction(
        onSwipe = {
            Toast.makeText(context,"Edit",Toast.LENGTH_SHORT).show()
        },
        icon = {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "", modifier = Modifier.padding(20.dp))
        },
        background = Color.Green
    )

    val info = SwipeAction(
        onSwipe = {
            Toast.makeText(context,"Info",Toast.LENGTH_SHORT).show()
        },
        icon = {
            Icon(imageVector = Icons.Default.Info, contentDescription = "", modifier = Modifier.padding(20.dp))
        },
        background = Color.Yellow
    )



    SwipeableActionsBox(startActions = listOf(edit), endActions = listOf(info)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .clip(RoundedCornerShape(30))
                .border(shape = RoundedCornerShape(30), width = 2.dp, color = Color.Gray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Blue)
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Column {
                Text(text = "Title", fontFamily = FontFamily.Serif, fontSize = 30.sp)
                Text(text = "Random text", fontFamily = FontFamily.Serif, fontSize = 20.sp)
            }

        }
    }



}

@Preview
@Composable
fun swipablePreview(){
    Swipable()
}
