package org.sopt.sopkathon.data.purchase.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PurchaseInformationResponse (
    @SerialName("products")
    val products: List<ProductInformationResponse>

)

@Serializable
data class ProductInformationResponse (
    @SerialName("productId")
    val productId: Int,
    @SerialName("productName")
    val productName: String,
    @SerialName("productPrice")
    val productPrice: Int,
    @SerialName("productImage")
    val productImage: String,
)