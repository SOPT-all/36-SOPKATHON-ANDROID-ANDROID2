package org.sopt.sopkathon.data.detail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopkathon.data.detail.service.DetailCommentService
import org.sopt.sopkathon.data.detail.service.DetailPurchaseApplyService
import org.sopt.sopkathon.data.detail.service.DetailService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideGuideService(retrofit: Retrofit): DetailService =
        retrofit.create()

    @Provides
    @Singleton
    fun provideDetailCommentService(retrofit: Retrofit): DetailCommentService = retrofit.create()

    @Provides
    @Singleton
    fun provideDetailPurchaseApplyService(retrofit: Retrofit): DetailPurchaseApplyService = retrofit.create()
}