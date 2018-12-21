package es.justo.asee.samplemvp_dagger2.data.repository.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import es.justo.asee.samplemvp_dagger2.data.model.ListMeme
import es.justo.asee.samplemvp_dagger2.data.repository.MemeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkRepository(var memeAPI: MemeAPI): MemeRepository {

    private val memesLiveData = MutableLiveData<ListMeme>()

    private val callback = object: Callback<ListMeme> {
        override fun onFailure(call: Call<ListMeme>?, t: Throwable?) {
            Logger.d("Download of memes FAILED")
        }

        override fun onResponse(call: Call<ListMeme>?, response: Response<ListMeme>?) {
            memesLiveData.postValue(response?.body())
        }
    }

    init {
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun getMemes(): LiveData<ListMeme> {
        memeAPI.getMemeList().enqueue(callback)
        return memesLiveData;
    }

}
