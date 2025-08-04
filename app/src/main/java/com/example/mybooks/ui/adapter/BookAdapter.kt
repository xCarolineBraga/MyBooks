package com.example.mybooks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybooks.databinding.ItemBookBinding
import com.example.mybooks.entity.BookEntity
import com.example.mybooks.ui.viewholder.BookViewHolder

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {

    private var booklist : List<BookEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return booklist.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(booklist[position])
    }


    fun updateBooks(list: List<BookEntity>) {
        booklist = list
        notifyDataSetChanged()
    }
}