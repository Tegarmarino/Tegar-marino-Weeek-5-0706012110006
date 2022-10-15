package com.uc.week4retrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.model.Result
import com.uc.week4retrofit.view.MovieDetail


class NowPlayingAdapter(private val dataSet: ArrayList<Result>) :
        RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

//        Membuat 2 variable baru
        val tvTitle : TextView
        val tvReleased: TextView
        val cvNowPlaying : CardView

        init {
            // Define click listener for the ViewHolder's View.

//            Memberikan value dari variable tvTitle tvReleased di dalam init
            tvTitle = view.findViewById(R.id.cv_title_now_playing)
            tvReleased = view.findViewById(R.id.cv_released_now_playing)
            cvNowPlaying = view.findViewById(R.id.cv_now_playing)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_now_playing, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

//        Menambahkan 2 view holder yg digunakan untuk memanggil data dari model Result yaitu title dan release_date
        viewHolder.tvTitle.text = dataSet[position].title

        viewHolder.tvReleased.text = dataSet[position].release_date
//        Melempar ID ke dalam view detail agar data di movie detail bisa load data dari API
        viewHolder.cvNowPlaying.setOnClickListener{
//            Menggunakan it untuk menambil context dari cvNowPlaying
            val intent = Intent(it.context, MovieDetail::class.java)
//            Melempar ID movie_id yg memiliki type data Integer
//            Inisialisasi name movie_id untuk kirim data ke MovieDetail
            intent.putExtra("movie_id", dataSet[position].id)
            it.context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

