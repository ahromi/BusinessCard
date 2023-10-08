package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.purple_200)
                    //color = MaterialTheme.colorScheme.background
                ) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page(modifier: Modifier = Modifier) {
    val phone = stringResource(R.string.phone)
    val socmed = stringResource(R.string.socmed)
    val email = stringResource(R.string.email)
    val image = painterResource(R.drawable.android_logo)
    val name = stringResource(R.string.nama)
    val title = stringResource(R.string.title)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        TopPart(
            image = image,
            name = name,
            title = title
        )
        BottomPart(
            phone = phone,
            socmed = socmed,
            email = email
        )
    }
}

@Composable
private fun TopPart(image: Painter, name: String, title:String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(bottom = 116.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(64.dp)
                .width(64.dp)
        )
        Text(
            text = name,
            fontSize = 45.sp
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.bgcolor)
        )
    }
}

@Composable
private fun BottomPart(phone: String, socmed: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .padding(top = 116.dp, bottom = 16.dp)
    ) {
        Row {
            Icon(
                Rounded.Phone,
                contentDescription = "Phone Number",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = phone,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row {
            Icon(
                Rounded.Share,
                contentDescription = "Social Media",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = socmed,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row {
            Icon(
                Rounded.Email,
                contentDescription = "Email",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = email,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Page()
    }
}