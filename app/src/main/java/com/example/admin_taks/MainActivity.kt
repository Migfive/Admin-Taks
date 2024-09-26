package com.example.admin_taks

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.admin_taks.ui.theme.AdminTaksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdminTaksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        message = stringResource(R.string.all_tasks_completed),
                        from = stringResource(R.string.nice_work),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier=Modifier){
    Column(modifier = modifier.fillMaxWidth(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Text(
            text = message,
            modifier = Modifier.padding(top =24.dp, bottom =8.dp ),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = from,
            fontSize = 16.sp
        )
    }
}

@Composable
fun GreetingImage(message:String, from:String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        GreetingText(
            message = message, from =from
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdminTaksTheme {
        GreetingImage(
            message = stringResource(R.string.all_tasks_completed),
            from = stringResource(R.string.nice_work)
        )
    }
}