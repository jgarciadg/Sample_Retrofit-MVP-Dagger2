package es.justo.asee.samplemvp_dagger2.data.repository.network

import es.justo.asee.samplemvp_dagger2.data.model.ListMeme
import retrofit2.Call
import retrofit2.http.GET

interface MemeAPI {
    @GET(value = "get_memes")
    fun getMemeList(): Call<ListMeme>
}