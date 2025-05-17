package org.sopt.sopkathon.presentation.purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.sopkathon.R
import org.sopt.sopkathon.core.designsystem.component.PurchaseItem
import org.sopt.sopkathon.core.designsystem.component.TopBar
import org.sopt.sopkathon.core.designsystem.theme.SOPKATHONTheme
import org.sopt.sopkathon.core.designsystem.theme.SopkathonTheme
import org.sopt.sopkathon.core.util.noRippleClickable
import org.sopt.sopkathon.data.purchase.dto.response.ProductInformationResponse
import org.sopt.sopkathon.data.purchase.dto.response.PurchaseInformationResponse
import org.sopt.sopkathon.presentation.purchase.state.PurchaseContract.PurchaseState

@Composable
fun PurchaseRoute(
    navigateToUp: () -> Unit,
    navigateToDetail: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PurchaseViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.get()
    }

    PurchaseScreen(
        list = viewModel.list,
        navigateToDetail = navigateToDetail,
        navigateToUp = navigateToUp,
        modifier = modifier,
    )
}

@Composable
private fun PurchaseScreen(
    list: PurchaseInformationResponse,
    navigateToDetail: () -> Unit,
    navigateToUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            TopBar(
                isPurchase = true,
                onBackClick = navigateToUp,
            )
        }

        item {
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
        items(
            count = list.products.size
        ) {
            PurchaseItem(
                name = list.products[it].productName,
                price = list.products[it].productPrice.toString(),
                image = list.products[it].productImage,
                modifier = Modifier.noRippleClickable(navigateToDetail)
            )
        }

    }
}

@Preview
@Composable
private fun dd() {

    SOPKATHONTheme {

    }

}