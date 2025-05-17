package org.sopt.sopkathon.data.purchase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopkathon.data.purchase.repository.PurchaseRepository
import org.sopt.sopkathon.data.purchase.service.PurchaseInformationService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePurchaseRepository(purchaseService: PurchaseInformationService): PurchaseRepository =
        PurchaseRepository(purchaseService)
}