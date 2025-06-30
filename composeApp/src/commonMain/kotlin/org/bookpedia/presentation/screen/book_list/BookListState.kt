package org.bookpedia.presentation.screen.book_list

import org.bookpedia.domain.model.Book

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResult: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTapIndex:Int = 0,
)
