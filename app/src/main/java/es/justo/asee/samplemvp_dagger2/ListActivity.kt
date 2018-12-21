package es.justo.asee.samplemvp_dagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.orhanobut.logger.Logger
import es.justo.asee.samplemvp_dagger2.adapter.MemeAdapter
import es.justo.asee.samplemvp_dagger2.di.root.App
import es.justo.asee.samplemvp_dagger2.mvp.ListActivityMVP
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : AppCompatActivity(), ListActivityMVP.View {
    @Inject
    lateinit var presenter: ListActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        (application as App).component.inject(this)

        presenter.setView(this)

        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = MemeAdapter()
        recycler_view.layoutManager = StaggeredGridLayoutManager(2,1)
    }

    override fun showImageClicked(position: Int) {
        Toast.makeText(this, "Clicked Image in position $position", Toast.LENGTH_SHORT).show()
    }

    override fun setListData(images: List<String>) {
        Toast.makeText(this, "SetData called", Toast.LENGTH_SHORT).show()
        Logger.i("info: ${images.size}")

        (recycler_view.adapter as MemeAdapter).setData(images)
    }

    override fun showDataNotAvailable() {
        Toast.makeText(this, "Data Not Available", Toast.LENGTH_SHORT).show()
    }

    override fun showDataWaiting() {
        Toast.makeText(this, "Waiting Data", Toast.LENGTH_SHORT).show()
    }

}
