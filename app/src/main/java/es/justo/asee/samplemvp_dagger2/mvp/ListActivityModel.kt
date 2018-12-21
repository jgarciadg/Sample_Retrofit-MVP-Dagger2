package es.justo.asee.samplemvp_dagger2.mvp

import android.arch.lifecycle.LiveData
import es.justo.asee.samplemvp_dagger2.data.model.ListMeme
import es.justo.asee.samplemvp_dagger2.data.repository.MemeRepository

class ListActivityModel (var repository: MemeRepository) : ListActivityMVP.Model {

    override fun getListData(): LiveData<ListMeme> {
        return repository.getMemes()
    }
}