package es.justo.asee.samplemvp_dagger2.data.repository

import android.arch.lifecycle.LiveData
import es.justo.asee.samplemvp_dagger2.data.model.ListMeme

interface MemeRepository {
    fun getMemes(): LiveData<ListMeme>
}