package johnnyk77.android.tobeadopted.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import johnnyk77.android.tobeadopted.data.dataSource.RemoteDataSource
import johnnyk77.android.tobeadopted.data.dataSource.RemoteDataSourceImpl
import johnnyk77.android.tobeadopted.data.repository.RemoteRepositoryImpl
import johnnyk77.android.tobeadopted.data.service.ApiService
import johnnyk77.android.tobeadopted.domain.repository.RemoteRepository
import johnnyk77.android.tobeadopted.domain.usecase.WaitAnimalListUseCase

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideWaitAnimalDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideWaitAnimalRepository(remoteDataSource: RemoteDataSource): RemoteRepository {
        return RemoteRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun provideWaitAnimalUseCase(remoteRepository: RemoteRepository): WaitAnimalListUseCase {
        return WaitAnimalListUseCase(remoteRepository)
    }
}