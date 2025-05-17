package org.sopt.sopkathon.presentation.guide

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.sopt.sopkathon.core.designsystem.component.TopBar
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.colors
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.typography
import org.sopt.sopkathon.data.guide.dto.response.GuideResponse

@Composable
fun GuideRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: GuideViewModel = hiltViewModel()
) {
    val regionId = 1L
    val guideData by viewModel.guideData.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getGuideData(regionId)
    }

    GuideScreen(
        guideData = guideData,
        onBackClick = { onBackClick() },
    )
}

@Composable
private fun GuideScreen(
    guideData: GuideResponse?,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = guideData?.regionImage,
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
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            guideData?.let {
                Text(
                    text = it.regionName,
                    style = typography.titleB24,
                    color = colors.black,
                    modifier = Modifier.padding(top = 24.dp)
                )
            }

            guideData?.let {
                Text(
                    text = it.regionSubName,
                    style = typography.bodyB16,
                    color = colors.gray800,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            guideData?.let {
                GuideSection(it.regionDescription)
            }
        }
    }
}

@Composable
fun GuideSection(rawText: String) {
    val lines = rawText
        .split("\n")
        .map { it.trim() }
        .filter { it.isNotBlank() }

    Column(modifier = Modifier.padding(top = 8.dp)) {
        // 1. 지역 설명 2줄
        lines.getOrNull(0)?.let {
            Text(
                text = it,
                style = typography.captionR12,
                color = colors.black
            )
        }
        lines.getOrNull(1)?.let {
            Text(
                text = it,
                style = typography.captionR12,
                color = colors.black
            )
        }

        // 2. LOCAL HIGHLIGHT 헤더
        Text(
            text = "LOCAL HIGHLIGHT",
            style = typography.bodyB18,
            color = colors.black,
            modifier = Modifier.padding(top = 8.dp)
        )

        // 3. 이후 아이템 블럭 (4줄씩)
        val itemLines = lines.drop(2)
        val items = itemLines.chunked(4)

        items.forEach { item ->
            Column(modifier = Modifier.padding(top = 18.dp)) {
                item.getOrNull(0)?.let {
                    Text(
                        text = it,
                        style = typography.bodyB16,
                        color = colors.black
                    )
                }

                item.getOrNull(1)?.let {
                    Text(
                        text = it,
                        style = typography.bodyB14,
                        color = colors.black
                    )
                }

                item.drop(2).forEach {
                    Text(
                        text = it,
                        style = typography.captionR12,
                        color = colors.black
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun GuideScreenPreview() {
    SOPKATHONTheme {
        GuideScreen(
            guideData = null,
            onBackClick = {}
        )
    }
}
