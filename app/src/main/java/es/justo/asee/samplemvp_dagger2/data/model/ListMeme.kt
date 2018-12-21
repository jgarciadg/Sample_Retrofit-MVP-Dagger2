package es.justo.asee.samplemvp_dagger2.data.model

import com.google.gson.annotations.SerializedName

data class ListMeme(
        val success: Boolean,
        @SerializedName("data")
        val memes: Memes
)