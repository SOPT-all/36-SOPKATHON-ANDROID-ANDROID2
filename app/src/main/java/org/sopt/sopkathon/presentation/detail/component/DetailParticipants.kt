package org.sopt.sopkathon.presentation.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme
import org.sopt.sopkathon.presentation.map.component.MapGoStoreButton

@Composable
fun DetailParticipants(
    teamName : String,
    count : Int,
    onClickButton : () -> Unit,
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(SopkathonTheme.colors.white)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 33.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        ){
            Text(
                text = "TEAM ",
                style = SopkathonTheme.typography.captionB10,
                color = SopkathonTheme.colors.black
            )

            Text(
                text = teamName,
                style = SopkathonTheme.typography.captionR12,
                color = SopkathonTheme.colors.black
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$count",
                style = SopkathonTheme.typography.captionR10,
                color = SopkathonTheme.colors.green1
            )

            Text(
                text = "명 참여 중",
                style = SopkathonTheme.typography.captionR10,
                color = SopkathonTheme.colors.black
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "침여하기",
                style = SopkathonTheme.typography.captionB10,
                color = SopkathonTheme.colors.black,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .clip(RoundedCornerShape(50))
                    .background(SopkathonTheme.colors.green2)
                    .clickable { onClickButton() }
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailParticipantsPreview() {
    SOPKATHONTheme {
        DetailParticipants(
            teamName = "경주",
            count = 2,
            onClickButton = {}
        )
    }
}