package org.sopt.sopkathon.presentation.purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.component.TopBar
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme

@Composable
fun PurchaseRoute(
    navigateToUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PurchaseScreen(
        navigateToUp = navigateToUp,
        modifier = modifier,
    )
}

@Composable
private fun PurchaseScreen(
    navigateToUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.background(color = SopkathonTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBar(
            isPurchase = true,
            onBackClick = navigateToUp,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.img_tomato),
                contentDescription = null,
            )

            Image(
                imageVector = ImageVector.vectorResource(R.drawable.img_quote),
                contentDescription = null,
            )
        }
    }

}

@Preview
@Composable
private fun MapScreenPreview() {
    SOPKATHONTheme {
        PurchaseScreen(
            navigateToUp = {},
        )
    }
}
