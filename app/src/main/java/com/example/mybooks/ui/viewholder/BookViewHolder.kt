package com.example.mybooks.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.mybooks.databinding.ItemBookBinding
import com.example.mybooks.entity.BookEntity

class BookViewHolder(private val item: ItemBookBinding) : RecyclerView.ViewHolder(item.root) {
    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
    }
}