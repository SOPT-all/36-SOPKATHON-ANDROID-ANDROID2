package org.sopt.sopkathon.presentation.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.sopkathon.R
import org.sopt.sopkathon.R.drawable.ic_splash_character
import org.sopt.sopkathon.core.designsystem.component.MapSelectButton
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme
import org.sopt.sopkathon.core.util.noRippleClickable

@Composable
fun MapButtonRoute(
    navigateUp: () -> Unit,
    guideButtonClick: () -> Unit,
    purchaseButtonClick: (Long?) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MapButtonViewmodel = hiltViewModel()
){
    MapButtonScreen(
        modifier = modifier,
        navigateUp = navigateUp,
        guideButtonClick = guideButtonClick,
        purchaseButtonClick = {
            purchaseButtonClick(1)
        }
    )
}
@Composable
fun MapButtonScreen(
    navigateUp: () -> Unit,
    guideButtonClick: () -> Unit,
    purchaseButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.background),
    ) {
        TopBarMapButton(
            onBackClick = navigateUp
        )

        Spacer(modifier = Modifier.height(108.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(ic_splash_character),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 110.dp)
            )

            Spacer(modifier = Modifier.height(37.dp))

            MapSelectButton(
                isSelectGuide = true,
                onClick = guideButtonClick
            )

            Spacer(modifier = Modifier.height(37.dp))

            MapSelectButton(
                isSelectGuide = false,
                onClick = purchaseButtonClick
            )
        }
    }
}


@Composable
private fun TopBarMapButton(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_left_black),
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(start = 20.dp)
                .noRippleClickable { onBackClick() }
                .align(Alignment.CenterStart)
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_splash_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .width(86.dp)
                .height(31.82f.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun MapButtonScreenPreview() {
    SOPKATHONTheme {
        MapButtonScreen(
            guideButtonClick = {},
            purchaseButtonClick = {},
            navigateUp = {}
        )
    }
}