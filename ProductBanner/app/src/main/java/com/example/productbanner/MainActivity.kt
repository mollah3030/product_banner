package com.example.productbanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // We use standard MaterialTheme here to avoid file dependency errors
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductBannerScreen()
                }
            }
        }
    }
}

@Composable
fun ProductBannerScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 1. Product Image in Background
        Image(
            // Make sure your image file is named "headphone_bg" in res/drawable
            painter = painterResource(id = R.drawable.headphone_bg),
            contentDescription = "Zenith Headphones Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 2. Gradient Overlay (For text readability)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f)
                        ),
                        startY = 300f
                    )
                )
        )

        // 3. Text Content
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(24.dp)
        ) {
            Text(
                text = "ZENITH WIRELESS",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

            Text(
                text = "AudioTech Solutions",
                color = Color.LightGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contact Info Block
            Column(
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.2f), shape = MaterialTheme.shapes.medium)
                    .padding(12.dp)
            ) {
                Text(
                    text = "Order Now:",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "www.audiotech.com | +1 (555) 019-2834",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}