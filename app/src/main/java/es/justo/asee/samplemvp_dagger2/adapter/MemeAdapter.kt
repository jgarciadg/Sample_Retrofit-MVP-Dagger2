package es.justo.asee.samplemvp_dagger2.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import es.justo.asee.samplemvp_dagger2.R
import es.justo.asee.samplemvp_dagger2.data.model.Meme
import es.justo.asee.samplemvp_dagger2.mvp.ListActivityMVP
import kotlinx.android.synthetic.main.meme_item.view.*

class MemeAdapter: RecyclerView.Adapter<MemeViewHolder>(){
    private lateinit var urls: List<String>

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MemeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_item, parent, false)
        return MemeViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(::urls.isInitialized)
            return urls.size
        else
            return 0
    }

    override fun onBindViewHolder(viewHolder: MemeViewHolder, position: Int) {
        Picasso.get()
                .load(urls[position])
                .into(viewHolder.imageViewMeme)
    }

    fun setData(urls: List<String>){
        this.urls = urls
        notifyDataSetChanged()
    }
}

class MemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var imageViewMeme = itemView.imageViewMeme
}