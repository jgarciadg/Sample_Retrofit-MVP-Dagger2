package es.justo.asee.samplemvp_dagger2.di.root

import dagger.Component
import es.justo.asee.samplemvp_dagger2.ListActivity
import es.justo.asee.samplemvp_dagger2.data.repository.network.APIModule
import es.justo.asee.samplemvp_dagger2.di.ListActivityModule
import es.justo.asee.samplemvp_dagger2.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules =
arrayOf(RepositoryModule::class,
        ApplicationModule::class,
        APIModule::class,
        ListActivityModule::class))
interface ApplicationComponent {

    fun inject(activity: ListActivity)
}