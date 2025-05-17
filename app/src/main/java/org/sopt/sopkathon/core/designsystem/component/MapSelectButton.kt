package org.sopt.sopkathon.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun MapSelectButton(
    isSelectGuide: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(color = if (isSelectGuide) colors.green2 else colors.beige)
            .height(118.dp)
            .padding(horizontal = 20.dp)
            .noRippleClickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(if (isSelectGuide) R.string.select_go_guide_title else R.string.select_go_purchase_title),
                color = colors.black,
                style = typography.bodyB16
            )

            Text(
                text = stringResource(if (isSelectGuide) R.string.select_go_guide_description else R.string.select_go_purchase_description),
                modifier = Modifier.padding(top = 5.dp),
                color = colors.gray800,
                style = typography.captionR10
            )
        }
        Image(
            imageVector = ImageVector.vectorResource(if (isSelectGuide) R.drawable.img_map else R.drawable.ic_arrow),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMapSelectButton() {
    SOPKATHONTheme {
        MapSelectButton(
            isSelectGuide = false,
            onClick = {},
        )
    }
}