package es.justo.asee.samplemvp_dagger2.mvp

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity

class ListActivityPresenter(var model: ListActivityMVP.Model): ListActivityMVP.Presenter {
    private lateinit var view: ListActivityMVP.View

    override fun setView(view: ListActivityMVP.View) {
        this.view = view

        model.getListData().observe(view as AppCompatActivity, Observer {
            val listData = arrayListOf<String>()

            it?.memes?.memes?.forEach {
                listData.add(it.url)
            }

            view.setListData(listData)
        })
    }

    override fun clickImage(position: Int) {
        view.showImageClicked(position)
    }
}