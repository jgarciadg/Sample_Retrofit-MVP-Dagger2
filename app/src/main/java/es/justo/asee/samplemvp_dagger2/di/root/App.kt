package es.justo.asee.samplemvp_dagger2.di.root

import android.app.Application
import es.justo.asee.samplemvp_dagger2.data.repository.network.APIModule
import es.justo.asee.samplemvp_dagger2.di.ListActivityModule
import es.justo.asee.samplemvp_dagger2.di.RepositoryModule

class App: Application() {
    val component by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .repositoryModule(RepositoryModule())
                .aPIModule(APIModule())
                .listActivityModule(ListActivityModule())
                .build()
    }
}