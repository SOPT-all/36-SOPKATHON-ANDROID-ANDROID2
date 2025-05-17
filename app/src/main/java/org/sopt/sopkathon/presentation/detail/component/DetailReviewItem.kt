package org.sopt.sopkathon.presentation.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme

@Composable
fun DetailReviewItem(
    nickName : String,
    score : Int,
    review : String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = nickName,
                style = SopkathonTheme.typography.captionB10,
                color = SopkathonTheme.colors.black
            )

            Row {
                repeat(score) {
                    Icon(
                        Icons.Default.Star,
                        tint = SopkathonTheme.colors.green3,
                        contentDescription = null,
                        modifier = modifier
                            .size(6.dp)
                    )
                }
            }
        }

        Spacer(modifier = modifier.width(10.dp))

        Text(
            text = review,
            style = SopkathonTheme.typography.captionR10,
            color = SopkathonTheme.colors.black
        )

        Spacer(modifier = Modifier.height(7.dp))

        HorizontalDivider(
            modifier = modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = SopkathonTheme.colors.gray200
        )
    }
}