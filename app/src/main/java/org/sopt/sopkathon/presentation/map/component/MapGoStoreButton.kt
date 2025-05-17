package org.sopt.sopkathon.presentation.map.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MapGoStoreButton(
    region : String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "$region 보러가기",
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(Color(0xFFE0EF9F))
            .clickable { onButtonClick() }
            .padding(horizontal = 20.dp, vertical = 10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MapGoStorePreview() {
    MapGoStoreButton(region = "경주", onButtonClick = {})
}