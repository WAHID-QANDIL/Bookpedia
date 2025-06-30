package org.bookpedia.presentation.screen.book_list

import org.bookpedia.domain.model.Book

sealed interface BookListAction {
    data class OnSearchQueryChanged(val query:String): BookListAction
    data class OnBookClicked(val book: Book): BookListAction
    data class OnTapSelected(val index:Int): BookListAction
}