package org.sopt.sopkathon.data.detail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopkathon.data.detail.respository.DetailRepository
import org.sopt.sopkathon.data.detail.service.DetailCommentService
import org.sopt.sopkathon.data.detail.service.DetailPurchaseApplyService
import org.sopt.sopkathon.data.detail.service.DetailService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDetailRepository(
        detailService: DetailService,
        detailCommentService: DetailCommentService,
        detailPurchaseApplyService: DetailPurchaseApplyService
    ): DetailRepository =
        DetailRepository(detailService, detailCommentService, detailPurchaseApplyService)
}