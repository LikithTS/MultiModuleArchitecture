package com.likith.multimodulearchitectureapp

import com.likith.navigation.Contracts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppMultiModuleProvider {

    @Provides
    @Singleton
    fun provideContracts(): Contracts {
        return MultiModuleContracts()
    }
}