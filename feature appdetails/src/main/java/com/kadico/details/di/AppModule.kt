package com.kadico.details.di

import android.app.Application
import androidx.room.Room
import com.kadico.details.data.AppDetailsRepositoryImpl
import com.kadico.details.data.SimilarAppMapper
import com.kadico.details.data.SimilarAppsApi
import com.kadico.details.data.SimilarAppsRepositoryImpl
import com.kadico.details.data.local.AppApi
import com.kadico.details.data.local.AppDatabase
import com.kadico.details.data.local.AppDetailsDao
import com.kadico.details.data.local.AppDetailsEntityMapper
import com.kadico.details.data.local.AppDetailsMapper
import com.kadico.details.domain.AppDetailsRepository
import com.kadico.details.domain.GetAppDetailsUseCase
import com.kadico.details.domain.GetSimilarAppsUseCase
import com.kadico.details.domain.SimilarAppsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://185.103.109.134")
            .addConverterFactory(Json{
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideAppApi(retrofit: Retrofit): AppApi {
        return retrofit.create(AppApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideAppDetailsRepository(appApi: AppApi): AppDetailsRepository {
//        return AppDetailsRepositoryImpl(appApi)
//    }

    @Provides
    @Singleton
    fun provideGetAppDetailsUseCase(repository: AppDetailsRepository): GetAppDetailsUseCase {
        return GetAppDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao {
        return database.appDetailsDao()
    }

    @Provides
    @Singleton
    fun provideAppDetailsEntityMapper(): AppDetailsEntityMapper {
        return AppDetailsEntityMapper()
    }

    @Provides
    @Singleton
    fun provideAppDetailsMapper(): AppDetailsMapper {
        return AppDetailsMapper()
    }

    @Provides
    @Singleton
    fun provideAppDetailsRepository(
        api: AppApi,
        dao: AppDetailsDao,
        mapper: AppDetailsMapper,
        entityMapper: AppDetailsEntityMapper
    ): AppDetailsRepository {
        return AppDetailsRepositoryImpl(api, dao, mapper, entityMapper)
    }

    @Provides
    @Singleton
    fun provideSimilarAppsApi(): SimilarAppsApi = SimilarAppsApi()

    @Provides
    @Singleton
    fun provideSimilarAppMapper(): SimilarAppMapper = SimilarAppMapper()

    @Provides
    @Singleton
    fun provideSimilarAppsRepository(
        api: SimilarAppsApi,
        mapper: SimilarAppMapper,
    ): SimilarAppsRepository = SimilarAppsRepositoryImpl(api, mapper)

    @Provides
    @Singleton
    fun provideGetSimilarAppsUseCase(repository: SimilarAppsRepository): GetSimilarAppsUseCase =
        GetSimilarAppsUseCase(repository)
}
