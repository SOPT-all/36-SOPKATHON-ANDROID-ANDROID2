package org.sopt.sopkathon.data.guide.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopkathon.data.guide.respository.GuideRepository
import org.sopt.sopkathon.data.guide.service.GuideService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideGuideRepository(guideService: GuideService): GuideRepository =
        GuideRepository(guideService)
}