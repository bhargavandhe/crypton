package com.bhargav.crypton.di

import com.bhargav.crypton.common.Constants
import com.bhargav.crypton.data.remote.CoinGeckoApi
import com.bhargav.crypton.data.repository.CryptonRepositoryImpl
import com.bhargav.crypton.domain.repository.CryptonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGeckoApi(): CoinGeckoApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinGeckoApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinGeckoApi): CryptonRepository = CryptonRepositoryImpl(api = api)
}
