package es.justo.asee.samplemvp_dagger2.di

import dagger.Module
import dagger.Provides
import es.justo.asee.samplemvp_dagger2.data.repository.MemeRepository
import es.justo.asee.samplemvp_dagger2.data.repository.network.NetworkRepository
import es.justo.asee.samplemvp_dagger2.data.repository.network.APIModule
import es.justo.asee.samplemvp_dagger2.data.repository.network.MemeAPI

@Module(includes = arrayOf(APIModule::class))
class RepositoryModule {
    @Provides
    fun provideMemeRepository(memeAPI: MemeAPI): MemeRepository {
        return NetworkRepository(memeAPI)
    }
}