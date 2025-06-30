package org.bookpedia.presentation.screen.book_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreen(
    viewModel: BookListViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    BookListScreenContent(
        modifier = modifier,
        uiState = uiState
    )

}


@Composable
private fun BookListScreenContent(
    modifier: Modifier = Modifier,
    uiState: BookListState
) {


}