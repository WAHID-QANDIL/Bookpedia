package org.bookpedia.presentation.screen.book_list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.bookpedia.domain.model.Book
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BookList(
    modifier: Modifier = Modifier,
    books: List<Book>,
    scrollState: LazyListState = rememberLazyListState(),
    onBookClick: (Book) -> Unit,
) {

    LazyColumn(
        modifier = modifier,
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items = books, key = { it.id }) { book ->
            BookListItem(
                book = book,
                onBookClick = {
                    onBookClick(book)
                },
                modifier = Modifier.widthIn(max = 700.dp).fillMaxWidth().padding(16.dp)
            )
        }
    }


}