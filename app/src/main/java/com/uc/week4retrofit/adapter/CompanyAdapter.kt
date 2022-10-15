package com.uc.week4retrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.week4retrofit.R
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.model.MovieDetails
import com.uc.week4retrofit.model.ProductionCompany

// Menggunakan List dikarenakan menggunakan List bukan arraylist
class CompanyAdapter(private val dataSet: List<ProductionCompany>) :
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //        Membuat variable baru untuk inisialsisasi Genre
        val ivCompany : ImageView

        init {
            // Define click listener for the ViewHolder's View.

//            Memberikan value dari variable tvTitle tvReleased di dalam init
            ivCompany = view.findViewById(R.id.iv_company)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.company, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

//        Menambahkan view holder yg digunakan untuk memanggil data dari model genre yaitu name
//        Menambahkan Glide didalam adapter ini untuk ditransfer
        Glide.with(viewHolder.itemView)
//                position sama hal nya dengan ID, jadi kita memanggil ID
            .load(Const.IMG_URL + dataSet[position].logo_path)
//                viewholder sama seperti binding tetapi hanya digunakan didalam class bukan activity
            .into(viewHolder.ivCompany)


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

