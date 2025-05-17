package org.sopt.sopkathon.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme
import org.sopt.sopkathon.presentation.detail.component.DetailParticipants
import org.sopt.sopkathon.presentation.detail.component.DetailReviewItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .background(SopkathonTheme.colors.white)
                    ) {
                        Row(
                            modifier = modifier
                                .padding(vertical = 7.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Box(
                                modifier = modifier.padding(
                                    start = 10.dp,
                                    end = 9.dp,
                                    top = 7.dp,
                                    bottom = 7.dp
                                ),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_black),
                                    contentDescription = null,
                                    modifier = modifier
                                        .clickable {
                                            //navigateUp()
                                        }
                                )

                                Image(
                                    painter = painterResource(R.drawable.ic_splash_logo),
                                    contentDescription = null,
                                    modifier = modifier
                                )
                            }
                        }
                    }
                }
            )
        },
        content = {
            DetailScreen(
                paddingValues = it,
                modifier = modifier
            )
        }
    )
}

@Composable
private fun DetailScreen(
    paddingValues : PaddingValues,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        //Todo : 나중에 데이터 받아온 사진 및 데이터들로 수정
        Column (
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(SopkathonTheme.colors.white)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            )

            //제목
            Text(
                text = "",
                style = SopkathonTheme.typography.bodyB20,
                color = SopkathonTheme.colors.black
            )
            //가격
            Text(
                text = "",
                style = SopkathonTheme.typography.bodyB14,
                color = SopkathonTheme.colors.black
            )

            //캡션
            Text(
                text = "",
                style = SopkathonTheme.typography.captionR10,
                color = SopkathonTheme.colors.black
            )

            //설명
            Text(
                text = "",
                style = SopkathonTheme.typography.captionR12,
                color = SopkathonTheme.colors.gray800
            )
        }

        Spacer(modifier = modifier.height(33.dp))

        //Todo 데이터로 변경
        DetailParticipants(
            teamName = "경주",
            count = 2,
            onClickButton = {}
        )

        Spacer(modifier = modifier.height(33.dp))

        Text(
            text = "후기",
            style = SopkathonTheme.typography.bodyB16,
            color = SopkathonTheme.colors.black
        )

        //Todo 데이터 변경
        LazyColumn (
            modifier = modifier.size(300.dp)
        ){
            items(10) {
                DetailReviewItem(
                    nickName = "닉네임",
                    score = 5,
                    review = "리뷰"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    SOPKATHONTheme {
        DetailScreen(
            paddingValues = PaddingValues(0.dp)
        )
    }
}
