package org.bookpedia.presentation.screen.book_list

import org.bookpedia.core.presentation.UiText
import org.bookpedia.domain.model.Book

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResult: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null,
    val selectedTapIndex:Int = 0,
)
val books = (1..100)
    .map {
        Book(
            id = it.toString(),
            title = it.toString(),
            imageUrl = "",
            authors = emptyList(),
            description = "",
            languages = emptyList(),
            firstPublishedYear = "",
            averageRating = 3.2,
            ratingCount = 2,
            numPages = 2,
            numEditions = 2
        )
    }