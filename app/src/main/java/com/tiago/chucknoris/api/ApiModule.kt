package com.tiago.chucknoris.api

import com.tiago.chucknoris.BuildConfig
import com.tiago.chucknoris.util.RetrofitUtils.getAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesApi(): ChuckApi {
        return getAPI(ChuckApi::class.java, BuildConfig.BASE_URL)
    }
}