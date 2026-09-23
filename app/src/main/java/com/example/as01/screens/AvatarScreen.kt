package com.example.as01.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.as01.R
import com.example.as01.ui.theme.Purple40
import com.example.as01.ui.theme.Typography

@Composable
fun AvatarScreen(modifier: Modifier = Modifier) {
    val faceComponents = remember {
        mutableStateListOf<FaceComponent>().apply {
            add(FaceComponent(R.drawable.face_0000, "Component 1", enabled = false))
            add(FaceComponent(R.drawable.face_0001, "Component 2", enabled = false))
            add(FaceComponent(R.drawable.face_0002, "Component 3", enabled = false))
            add(FaceComponent(R.drawable.face_0003, "Component 4", enabled = false))
            add(FaceComponent(R.drawable.face_0004, "Component 5", enabled = false))
        }
    }

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Avatar",
                style = Typography.bodyLarge,
                color = Purple40
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                faceComponents.forEach { component ->
                    if (component.enabled) {
                        androidx.compose.foundation.Image(
                            painter = painterResource(id = component.resId),
                            contentDescription = component.label,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(180.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            faceComponents.forEachIndexed { index, component ->
                CheckboxRow(
                    label = component.label,
                    checked = component.enabled,
                    onCheckedChange = {
                        faceComponents[index] = component.copy(enabled = !component.enabled)
                    }
                )
            }
        }
    }
}

data class FaceComponent(val resId: Int, val label: String, val enabled: Boolean = false)

@Composable
private fun CheckboxRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        androidx.compose.foundation.Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = label)
        }
    }
}