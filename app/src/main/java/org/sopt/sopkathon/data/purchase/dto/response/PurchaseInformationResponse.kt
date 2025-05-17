package org.sopt.sopkathon.data.purchase.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PurchaseInformationResponse (
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val productName: String,
    @SerialName("productThumbnail")
    val productThumbnail: String
)
