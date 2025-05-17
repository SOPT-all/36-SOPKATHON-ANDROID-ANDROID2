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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.jetbrains.annotations.Async
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme
import org.sopt.sopkathon.data.detail.dto.response.DetailCommentResponse
import org.sopt.sopkathon.data.detail.dto.response.DetailPurchaseApplyResponse
import org.sopt.sopkathon.data.detail.dto.response.DetailResponse
import org.sopt.sopkathon.presentation.detail.component.DetailParticipants
import org.sopt.sopkathon.presentation.detail.component.DetailReviewItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val detail by viewModel.detail.collectAsStateWithLifecycle()
    val comments by viewModel.comments.collectAsStateWithLifecycle()
    val purchaseApplies by viewModel.purchaseApplies.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadAll(1)
    }

    DetailScreen(
        detail,
        comments,
        purchaseApplies,
        modifier = modifier
    )
}

@Composable
private fun DetailScreen(
    detail: DetailResponse?,
    comments: List<DetailCommentResponse>,
    purchaseApplies: List<DetailPurchaseApplyResponse>,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(SopkathonTheme.colors.white)
        ) {
            AsyncImage(
                model = detail?.imageLinks[0],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            //제목
            Text(
                text = detail?.productName ?: "",
                style = SopkathonTheme.typography.bodyB20,
                color = SopkathonTheme.colors.black
            )
            Spacer(modifier = Modifier.height(10.dp))
            //가격
            Text(
                text = detail?.price.toString(),
                style = SopkathonTheme.typography.bodyB14,
                color = SopkathonTheme.colors.black
            )

            Spacer(modifier = Modifier.height(20.dp))

            //설명
            Text(
                text = detail?.description ?: "",
                style = SopkathonTheme.typography.captionR12,
                color = SopkathonTheme.colors.gray800
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        DetailParticipants(
            teamName = detail?.sellerName ?: "",
            count = detail?.participantCount ?: 0,
            onClickButton = {}
        )


        Text(
            text = "후기",
            style = SopkathonTheme.typography.bodyB16,
            color = SopkathonTheme.colors.black
        )
        Spacer(modifier = Modifier.height(10.dp))


        //Todo 데이터 변경

    }
}
