package org.sopt.sopkathon.presentation.guide

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.sopkathon.core.designsystem.component.TopBar
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.colors
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.typography

@Composable
fun GuideRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    GuideScreen(
        onBackClick = { onBackClick() },
        modifier = modifier
    )
}

@Composable
private fun GuideScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(249.dp),
                contentScale = ContentScale.Crop
            )
            TopBar(
                isPurchase = false,
                onBackClick = {
                    onBackClick()
                },
                modifier = Modifier.padding(top = 15.dp)
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                text = "시간이 빚은 맛의 도시, 경주",
                style = typography.titleB24,
                color = colors.black,
                modifier = Modifier.padding(top = 24.dp)
            )

            Text(
                text = "정갈하고 깊은 맛이 천년의 햇살 아래 자랍니다.",
                style = typography.bodyB16,
                color = colors.gray800,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "설명 들어 가야 할 부분"
            )
        }
    }
}

@Preview
@Composable
private fun GuideScreenPreview() {
    SOPKATHONTheme {
        GuideScreen(
            onBackClick = {}
        )
    }
}
