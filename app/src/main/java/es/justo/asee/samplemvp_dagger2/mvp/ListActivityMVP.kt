package es.justo.asee.samplemvp_dagger2.mvp

import android.arch.lifecycle.LiveData
import es.justo.asee.samplemvp_dagger2.data.model.ListMeme

interface ListActivityMVP {
    interface View {
        fun setListData(images: List<String>)

        fun showImageClicked(position: Int)
        fun showDataNotAvailable()
        fun showDataWaiting()

    }

    interface Presenter {
        fun setView(view: View)

        fun clickImage(position: Int)
    }

    interface Model {
        fun getListData(): LiveData<ListMeme>
    }
}