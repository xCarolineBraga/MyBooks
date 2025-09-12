package com.example.mybooks.ui.viewholder


import androidx.recyclerview.widget.RecyclerView
import com.example.mybooks.R
import com.example.mybooks.databinding.ItemBookBinding
import com.example.mybooks.entity.BookEntity
import com.example.mybooks.ui.listener.BookListener

class BookViewHolder(private val item: ItemBookBinding, private val listener: BookListener) :
    RecyclerView.ViewHolder(item.root) {

    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
        item.textviewGenre.text = book.genre
        item.textviewAuthor.text = book.author

        item.textviewTitle.setOnClickListener { listener.onClick(book.id) }

        item.imageviewFavorite.setOnClickListener { listener.onFavoriteClick(book.id) }

        setGenreBackground(book.genre)

        updateFavoriteIcon(book.favorite)
    }

    private fun updateFavoriteIcon(favorite: Boolean) {
        if (favorite) {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite)
        } else {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite_empty)
        }
    }

    private fun setGenreBackground(genre: String) {
        when (genre) {
            "Terror" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_terror)
            }

            "Fantasia" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fantasy)
            }

            "Ficção" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fiction)

            }

            "Romance" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_romance)
            }

            "Ficção policial" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_detectivefiction)
            }

            "Cyberpunk" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_cyberpunk)
            }

            "Mistério" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_mystery)
            }

            "Aventura" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_adventure)
            }
        }
    }

}