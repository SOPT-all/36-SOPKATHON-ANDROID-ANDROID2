package org.sopt.sopkathon.presentation.map

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.presentation.main.MainNavigator
import org.sopt.sopkathon.presentation.main.rememberMainNavigator
import org.sopt.sopkathon.presentation.map.component.ClickableMap
import org.sopt.sopkathon.presentation.map.component.MapGoStoreButton
import org.sopt.sopkathon.presentation.map.navigation.navigateToMapButton

@Composable
fun MapRoute(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit,
    viewModel: MapViewModel = hiltViewModel()
) {
    val regionId by viewModel.regionId.collectAsStateWithLifecycle()
    val regionName by viewModel.regionName.collectAsStateWithLifecycle()
    val guideList by viewModel.guideList.collectAsStateWithLifecycle()

    LaunchedEffect(regionId) {
        viewModel.fetchGuideIntroduction(regionId ?: 1)
    }

    MapScreen(
        description = guideList?.regionName ?: "",
        modifier = modifier,
        name = regionName ?: "경주",
        onClickRegion = {
            viewModel.fetchRegionId(it.toLong())

        },
        onClickRegionName = {
            viewModel.fetchRegionName(it)
        },
        onClickButton = {
            onClickButton()
        }
    )
}

@Composable
fun MapScreen(
    description : String,
    name : String,
    onClickRegion: (Int) -> Unit,
    onClickRegionName: (String) -> Unit,
    onClickButton : () -> Unit,
    modifier: Modifier = Modifier,
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
                        onClickRegion(1)
                        onClickRegionName("경주")
                    }

                    "청도" -> {
                        //2
                        onClickRegion(2)
                        onClickRegionName("청도")
                    }

                    "문경" -> {
                        //3
                        onClickRegion(3)
                        onClickRegionName("문경")
                    }

                    "안동" -> {
                        //4
                        onClickRegion(4)
                        onClickRegionName("안동")

                    }
                }
            }
        )

        Text(
            text = description,
            modifier = modifier
                .padding(top = 60.dp, bottom = 20.dp)
        )

        //Todo : 나중에 navigate로 다음 화면 이동 구현
        MapGoStoreButton(
            region = name,
            onButtonClick = {
                onClickRegionName(name)
                onClickButton()
            }
        )
    }
}
