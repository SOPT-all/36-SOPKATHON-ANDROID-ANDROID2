package org.sopt.sopkathon.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.colors
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme.typography

// TODO: 데이터는 알아서 받아와서 써주세요...
@Composable
fun PurchaseItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .wrapContentHeight()
    ) {
        AsyncImage(
            model = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400",
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            Text(
                text = "경주 체리",
                modifier = Modifier.padding(top = 10.dp),
                style = typography.bodyR14,
                color = colors.black
            )

            Text(
                text = "27,620원",
                style = typography.bodyB14,
                color = colors.black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPurchaseItem() {
    SOPKATHONTheme {
        PurchaseItem()
    }
}