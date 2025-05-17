package org.sopt.sopkathon.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.colors
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.typography
import org.sopt.sopkathon.core.util.noRippleClickable

@Composable
fun TopBar(
    isPurchase: Boolean,
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
        if (isPurchase) {
            Text(
                text = stringResource(id = R.string.top_bar_title),
                modifier = Modifier.align(Alignment.Center),
                color = colors.black,
                style = typography.bodyB16
            )
        }
    }
}

@Preview
@Composable
private fun PreviewTopBar() {
    SOPKATHONTheme {
        TopBar(
            isPurchase = true,
            onBackClick = {}
        )
    }
}