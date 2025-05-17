package org.sopt.sopkathon.presentation.map.component

import RegionTag
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.util.showToast

@Composable
fun ClickableMap(
    modifier : Modifier = Modifier,
    onClickRegion : (String) -> Unit
) {
    var markerOffset by remember { mutableStateOf<Offset?>(null) }
    var selectedRegion by remember { mutableStateOf<RegionTag?>(null) }
    val context = LocalContext.current

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            val boxWidth = constraints.maxWidth.toFloat()
            val boxHeight = constraints.maxHeight.toFloat()

            val mapSize = remember(boxWidth, boxHeight) { boxWidth to boxHeight }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(mapSize) {
                        detectTapGestures { offset ->
                            val (width, height) = mapSize
                            markerOffset = offset
                            selectedRegion = getRegionTagFromClick(offset, width, height)
                            Log.e(
                                "ClickableMap",
                                "Clicked Region: ${selectedRegion?.label}, Offset: $offset"
                            )  // 여기에 Log 넣기
                            context.showToast("Clicked Region: ${selectedRegion?.label}, Offset: $offset")
                            onClickRegion(selectedRegion?.label ?: "")
                        }
                    }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.map_svg),
                    contentDescription = "경상북도 지도",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(width = 320.dp, height = 334.dp)
                        .align(Alignment.Center)
                )

                markerOffset?.let { offset ->
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "선택된 위치",
                        tint = Color.Green,
                        modifier = Modifier
                            .offset {
                                IntOffset(
                                    offset.x.toInt() - 12,
                                    offset.y.toInt() - 24
                                )
                            }
                            .size(24.dp)
                    )
                }
            }
        }
    }
}

fun getRegionTagFromClick(clickOffset: Offset, boxWidth: Float, boxHeight: Float): RegionTag? {
    if (clickOffset.x in 700f..850f && clickOffset.y in 800f..950f) {
        return RegionTag.GYEONGJU
    }

    if (clickOffset.x in 450f..600f && clickOffset.y in 900f..980f) {
        return RegionTag.CHEONGDO
    }

    if (clickOffset.x in 240f..320f && clickOffset.y in 220f..300f) {
        return RegionTag.MUNGYEONG
    }

    if (clickOffset.x in 500f..600f && clickOffset.y in 350f..400f) {
        return RegionTag.ANDONG
    }
    return null
}

@Preview(showBackground = false)
@Composable
private fun ClickableMapPreview() {
    SOPKATHONTheme {
        ClickableMap(
            onClickRegion = {}
        )
    }
}