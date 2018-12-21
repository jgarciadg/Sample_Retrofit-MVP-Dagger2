package es.justo.asee.samplemvp_dagger2.di

import dagger.Module
import dagger.Provides
import es.justo.asee.samplemvp_dagger2.data.repository.MemeRepository
import es.justo.asee.samplemvp_dagger2.mvp.ListActivityMVP
import es.justo.asee.samplemvp_dagger2.mvp.ListActivityModel
import es.justo.asee.samplemvp_dagger2.mvp.ListActivityPresenter

@Module
class ListActivityModule {

    @Provides
    fun provideListActivityModel(repository: MemeRepository): ListActivityMVP.Model {
        return ListActivityModel(repository)
    }

    @Provides
    fun provideListActivityPresenter(model: ListActivityMVP.Model): ListActivityMVP.Presenter {
        return ListActivityPresenter(model)
    }
}