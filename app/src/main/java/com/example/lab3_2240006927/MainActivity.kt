package com.example.lab3_2240006927

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainAppScreen()
            }
        }
    }
}

enum class AppScreen(val title: String) {
    HOME("Lab 3 Tasks Menu"),
    TASK_1_2("Task 1 & Task 2 (ProfileCard & Status Badge)"),
    TASK_4("Task 4 (Order Puzzle)"),
    TASK_10("Task 10 (StudentListScreen & Scaffold)")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen() {
    var currentScreen by remember { mutableStateOf(AppScreen.HOME) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = currentScreen.title,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                // إضافة زر السهم للعودة للصفحة الرئيسية عند فتح أي تاسك
                navigationIcon = {
                    if (currentScreen != AppScreen.HOME) {
                        IconButton(onClick = { currentScreen = AppScreen.HOME }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        when (currentScreen) {
            AppScreen.HOME -> HomeScreen(
                modifier = modifier,
                onTask1Click = { currentScreen = AppScreen.TASK_1_2 },
                onTask4Click = { currentScreen = AppScreen.TASK_4 },
                onTask10Click = { currentScreen = AppScreen.TASK_10 }
            )
            AppScreen.TASK_1_2 -> ProfileScreen(modifier = modifier)
            AppScreen.TASK_4 -> OrderPuzzleScreen(modifier = modifier)
            AppScreen.TASK_10 -> StudentListScreen(modifier = modifier)
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onTask1Click: () -> Unit,
    onTask4Click: () -> Unit,
    onTask10Click: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select a Task to View Output",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Task 1 & 2 Button Card
        TaskItemCard(
            taskTitle = "Task 1 & Task 2",
            taskDescription = "ProfileCard & Status Badge",
            onClick = onTask1Click
        )

        // Task 4 Button Card
        TaskItemCard(
            taskTitle = "Task 4",
            taskDescription = "Order Puzzle (Modifier Chains)",
            onClick = onTask4Click
        )

        // Task 10 Button Card
        TaskItemCard(
            taskTitle = "Task 10",
            taskDescription = "StudentListScreen & Scaffold",
            onClick = onTask10Click
        )
    }
}

@Composable
fun TaskItemCard(
    taskTitle: String,
    taskDescription: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = taskTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = taskDescription,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}