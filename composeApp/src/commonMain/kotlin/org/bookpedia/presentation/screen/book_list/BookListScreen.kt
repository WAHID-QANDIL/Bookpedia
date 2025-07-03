package org.bookpedia.presentation.screen.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bookpedia.composeapp.generated.resources.Res
import bookpedia.composeapp.generated.resources.favorites
import bookpedia.composeapp.generated.resources.no_favorites_results
import bookpedia.composeapp.generated.resources.no_search_results
import bookpedia.composeapp.generated.resources.search_result
import org.bookpedia.core.presentation.DarkBlue
import org.bookpedia.core.presentation.DesertWhite
import org.bookpedia.core.presentation.SandYellow
import org.bookpedia.domain.model.Book
import org.bookpedia.presentation.screen.book_list.component.BookList
import org.bookpedia.presentation.screen.book_list.component.BookListSearchBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreen(
    viewModel: BookListViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    onBookClick: (Book) -> Unit,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    BookListScreenContent(
        modifier = modifier,
        uiState = uiState.copy(searchResult = listOf<Book>(
            Book(
                id = "1",
                title = "TODO()",
                imageUrl = "TODO()",
                authors = emptyList(),
                description = "TODO()",
                languages = emptyList(),
                firstPublishedYear = "TODO()",
                averageRating = 4.3,
                ratingCount = 22,
                numPages = 22,
                numEditions = 1
            ),
            Book(
                id = "2",
                title = "TODO()",
                imageUrl = "TODO()",
                authors = emptyList(),
                description = "TODO()",
                languages = emptyList(),
                firstPublishedYear = "TODO()",
                averageRating = 4.3,
                ratingCount = 22,
                numPages = 22,
                numEditions = 1
            ),
            Book(
                id = "3",
                title = "TODO()",
                imageUrl = "TODO()",
                authors = emptyList(),
                description = "TODO()",
                languages = emptyList(),
                firstPublishedYear = "TODO()",
                averageRating = 4.3,
                ratingCount = 22,
                numPages = 22,
                numEditions = 1
            )
            ,Book(
                id = "4",
                title = "TODO()",
                imageUrl = "TODO()",
                authors = emptyList(),
                description = "TODO()",
                languages = emptyList(),
                firstPublishedYear = "TODO()",
                averageRating = 4.3,
                ratingCount = 22,
                numPages = 22,
                numEditions = 1
            )
        )),
        onAction = { action ->
            when (action) {
                is BookListAction.OnBookClicked -> {
                    onBookClick(action.book)
                }

                else -> Unit
            }
            viewModel.onAction(action)
        }
    )

}


@Composable
private fun BookListScreenContent(
    modifier: Modifier = Modifier,
    uiState: BookListState,
    onAction: (BookListAction) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val bookListState = rememberLazyListState()
    val favoritesBooksListState = rememberLazyListState()

    LaunchedEffect(key1 = pagerState.currentPage){
        onAction(BookListAction.OnTapSelected(pagerState.currentPage))
    }

    LaunchedEffect(key1 = uiState.selectedTapIndex){
        pagerState.animateScrollToPage(uiState.selectedTapIndex)
    }




    Column(
        modifier = modifier.fillMaxSize().background(
            color = DarkBlue
        ).statusBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookListSearchBar(
            modifier = Modifier.widthIn(max = 700.dp).fillMaxWidth().padding(16.dp),
            searchQuery = uiState.searchQuery,
            onSearchQueryChanged = { onAction(BookListAction.OnSearchQueryChanged(it)) },
            onImeSearch = { keyboardController?.hide() }
        )
        Surface(
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp
            ),
            color = DesertWhite,
            modifier = Modifier.weight(1f).fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabRow(
                    selectedTabIndex = uiState.selectedTapIndex,
                    modifier = Modifier.padding(vertical = 12.dp)
                        .widthIn(700.dp).fillMaxWidth(),
                    indicator = { tapRow ->
                        TabRowDefaults.SecondaryIndicator(
                            color = SandYellow,
                            modifier = Modifier.tabIndicatorOffset(
                                currentTabPosition = tapRow[uiState.selectedTapIndex]
                            )
                        )
                    }
                ) {

                    Tab(
                        selected = uiState.selectedTapIndex == 0,
                        onClick = {
                            onAction(BookListAction.OnTapSelected(0))

                        },
                        modifier = Modifier.weight(1f),
                        selectedContentColor = SandYellow,
                        unselectedContentColor = Color.Black.copy(alpha = .5f)
                    ) {
                        Text(
                            text = stringResource(Res.string.search_result),
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                        )
                    }
                    Tab(
                        selected = uiState.selectedTapIndex == 1,
                        onClick = {
                            onAction(BookListAction.OnTapSelected(1))
                        },
                        modifier = Modifier.weight(1f),
                        selectedContentColor = SandYellow,
                        unselectedContentColor = Color.Black.copy(alpha = .5f)
                    ) {
                        Text(
                            text = stringResource(Res.string.favorites),
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth().weight(1f),
                ) { pageIndex ->

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        when (pageIndex) {
                            0 -> {
                                when {
                                    uiState.isLoading -> {
                                        CircularProgressIndicator()
                                    }

                                    uiState.errorMessage != null -> {
                                        Text(
                                            text = uiState.errorMessage.asString(),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }

                                    uiState.searchResult.isEmpty() -> {
                                        Text(
                                            text = stringResource(Res.string.no_search_results),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }

                                    else -> {
                                        BookList(
                                            books = uiState.searchResult,
                                            onBookClick = {
                                                onAction(BookListAction.OnBookClicked(it))
                                            },
                                            modifier = Modifier.fillMaxSize(),
                                            scrollState = bookListState
                                        )
                                    }
                                }
                            }

                            1 -> {
                                if (uiState.favoriteBooks.isEmpty()) {
                                    Text(
                                        text = stringResource(Res.string.no_favorites_results),
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.headlineSmall,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                } else {
                                    BookList(
                                        books = uiState.favoriteBooks,
                                        onBookClick = {
                                            onAction(BookListAction.OnBookClicked(it))
                                        },
                                        modifier = Modifier.fillMaxSize(),
                                        scrollState = favoritesBooksListState
                                    )
                                }


                            }
                        }

                    }


                }

            }

        }

    }

}

@Composable
@Preview
private fun BookListScreenPreview() {
    BookListScreen(
        viewModel = BookListViewModel(),
        onBookClick = { TODO() }
    )
}