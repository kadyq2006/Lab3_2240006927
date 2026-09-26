package com.example.lab3_2240006927

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OrderPuzzleScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Modifier Order Puzzle",
            style = MaterialTheme.typography.titleLarge
        )

        // Chain A
        Text(
            text = "content",
            color = Color.Black,
            modifier = Modifier
                .background(Color(0xFF80DEEA))
                .padding(24.dp)
                .clickable { }
        )

        // Chain B
        Text(
            text = "content",
            color = Color.Black,
            modifier = Modifier
                .padding(24.dp)
                .background(Color(0xFFFFF59D))
                .clickable { }
        )

        // Chain C
        Text(
            text = "content",
            color = Color.Black,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFFFAB91))
                .padding(24.dp)
                .clickable { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderPuzzlePreview() {
    MaterialTheme {
        OrderPuzzleScreen()
    }
}