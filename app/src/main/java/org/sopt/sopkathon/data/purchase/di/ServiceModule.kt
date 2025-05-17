package org.sopt.sopkathon.data.purchase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopkathon.data.purchase.service.PurchaseInformationService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providePurchaseService(retrofit: Retrofit): PurchaseInformationService =
        retrofit.create()
}