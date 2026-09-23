package com.example.as01.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
fun AvatarScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isBrowChecked = remember { mutableStateOf<Boolean>(false) }
    val isEyeChecked = remember { mutableStateOf<Boolean>(false) }
    val isNoseChecked = remember { mutableStateOf<Boolean>(false) }
    val isMouthChecked = remember { mutableStateOf<Boolean>(false) }

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                TextButton(onClick = onBack) {
                    Text("← Back")
                }
                Text(
                    text = "Avatar",
                    style = Typography.bodyLarge,
                    color = Purple40
                )
                TextButton(onClick = {}) {
                    Text("")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(220.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                AvatarViewer(
                    isBrowChecked = isBrowChecked.value,
                    isEyeChecked = isEyeChecked.value,
                    isNoseChecked = isNoseChecked.value,
                    isMouthChecked = isMouthChecked.value,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            CheckboxRow(label = "Eyelash", checked = isBrowChecked.value, onCheckedChange = { isBrowChecked.value = it })
            CheckboxRow(label = "Eye", checked = isEyeChecked.value, onCheckedChange = { isEyeChecked.value = it })
            CheckboxRow(label = "Nose", checked = isNoseChecked.value, onCheckedChange = { isNoseChecked.value = it })
            CheckboxRow(label = "Mouth", checked = isMouthChecked.value, onCheckedChange = { isMouthChecked.value = it })
        }
    }
}

@Composable
fun AvatarViewer(
    isBrowChecked: Boolean,
    isEyeChecked: Boolean,
    isNoseChecked: Boolean,
    isMouthChecked: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.body_head),
            contentDescription = "Head",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )

        if (isBrowChecked) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.eyelash),
                contentDescription = "Eyelash",
                modifier = Modifier
                    .size(width = 110.dp, height = 30.dp)
                    .offset(y = (-40).dp)
            )
        }

        if (isEyeChecked) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.eyes),
                contentDescription = "Eye",
                modifier = Modifier
                    .size(width = 110.dp, height = 45.dp)
                    .offset(y = (-20).dp)
            )
        }

        if (isNoseChecked) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.nose),
                contentDescription = "Nose",
                modifier = Modifier
                    .size(width = 40.dp, height = 35.dp)
                    .offset(y = 15.dp)
            )
        }

        if (isMouthChecked) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.mouth),
                contentDescription = "Mouth",
                modifier = Modifier
                    .size(width = 75.dp, height = 35.dp)
                    .offset(y = 50.dp)
            )
        }
    }
}

@Composable
private fun CheckboxRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = label)
    }
}