package com.example.mybooks.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mybooks.R

import com.example.mybooks.viewmodel.DetailsViewModel

import com.example.mybooks.databinding.FragmentDetailsBinding
import com.example.mybooks.helper.BookConstants


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()
    private var bookId = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, b: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)



        setObservers()

        setListener()

        bookId = arguments?.getInt(BookConstants.Key.BOOK_ID) ?: 0

        viewModel.getBookById(bookId)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun setListener() {
        binding.imageviewBack.setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun setObservers() {
        viewModel.book.observe(viewLifecycleOwner){

            binding.textviewTitle.text = it.title
            binding.textviewGenreValue.text = it.genre
            binding.textviewAuthorValue.text = it.author
            binding.checkboxFavorite.isChecked = it.favorite

            setGenreBackground(it.genre)
        }
    }

    private fun setGenreBackground (genre: String){
        when (genre) {
            "Terror" -> {
                binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_red)
            }
            "Fantasia" -> {
                binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_fantasy)
            }
            else -> {
                binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_teal)

            }
        }
    }

}