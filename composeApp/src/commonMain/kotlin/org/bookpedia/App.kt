package org.bookpedia

import androidx.compose.runtime.Composable
import org.bookpedia.presentation.screen.book_list.BookListScreen
import org.bookpedia.presentation.screen.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreen(
        viewModel = BookListViewModel(),
        onBookClick = {
        }
    )
}