package com.uc.week4retrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.model.SpokenLanguage

// Menggunakan List dikarenakan menggunakan List bukan arraylist
class SpokenLangguageAdapter(private val dataSet: List<SpokenLanguage>) :
    RecyclerView.Adapter<SpokenLangguageAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //        Membuat variable baru untuk inisialsisasi Genre
        val tvSpokenLanguage : TextView

        init {
            // Define click listener for the ViewHolder's View.

//            Memberikan value dari variable tvTitle tvReleased di dalam init
            tvSpokenLanguage = view.findViewById(R.id.tv_spoken_langgguage)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.spoken_langguage, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

//        Menambahkan view holder yg digunakan untuk memanggil data dari model genre yaitu name
        viewHolder.tvSpokenLanguage.text = dataSet[position].name
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

