package org.sopt.sopkathon.presentation.map

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.presentation.map.component.ClickableMap
import org.sopt.sopkathon.presentation.map.component.MapGoStoreButton

@Composable
fun MapRoute(
    modifier: Modifier = Modifier,
) {
    MapScreen(
        description = "천년의 도시 경주, 그 풍요로움을 담아드릴게요.",
        modifier = modifier,
        onClickRegion = {}
    )
}

@Composable
fun MapScreen(
    description : String,
    onClickRegion: (String) -> Unit,
    modifier: Modifier = Modifier,
    //Todo : 나중에 viewmodel로 데이터 변경, text 및 pill
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableMap(
            modifier = modifier,
            onClickRegion = {
                //Todo: api 구현
                when (it) {
                    "경주" -> {
                        //1
                    }

                    "청도" -> {
                        //2
                    }

                    "문경" -> {
                        //3
                    }

                    "안동" -> {
                        //4
                    }
                }
            }
        )

        Text(
            text = "천년의 도시 경주, 그 풍요로움을 담아드릴게요.",
            modifier = modifier
                .padding(top = 60.dp, bottom = 20.dp)
        )

        MapGoStoreButton(
            region = "경주",
            onButtonClick = {

            }
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun MapScreenPreview() {
    SOPKATHONTheme {
        MapScreen(
            description = "천년의 도시 경주, 그 풍요로움을 담아드릴게요.",
            onClickRegion = {}
        )
    }
}
