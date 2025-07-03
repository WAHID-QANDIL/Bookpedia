package org.bookpedia.presentation.screen.book_list.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import bookpedia.composeapp.generated.resources.Res
import bookpedia.composeapp.generated.resources.search_placeholder
import org.bookpedia.core.presentation.DarkBlue
import org.bookpedia.core.presentation.DesertWhite
import org.bookpedia.core.presentation.SandYellow
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BookListSearchBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onImeSearch: () -> Unit,
) {
    CompositionLocalProvider(
        LocalTextSelectionColors provides TextSelectionColors(
            backgroundColor = SandYellow,
            handleColor = SandYellow
        )
    ) {
        OutlinedTextField(
            modifier = modifier
                .background(
                    color = DesertWhite,
                    shape = RoundedCornerShape(100)

                )
                .minimumInteractiveComponentSize()
                .clip(
                    RoundedCornerShape(100)
                )
            ,
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = DarkBlue,
                focusedBorderColor = SandYellow
            ),
            placeholder = {
                Text(
                    text =
                        stringResource(Res.string.search_placeholder)
                )
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            },
            singleLine = true,

            keyboardActions = KeyboardActions(
                onSearch = {
                    onImeSearch()
                }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),

            trailingIcon = {
                AnimatedVisibility(visible = searchQuery.isNotBlank()) {
                    IconButton(onClick = { onSearchQueryChanged("") }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }

                }
            }


        )

    }


}

@Preview
@Composable
fun BookListSearchBarPreview(
) {

    BookListSearchBar(
        modifier = Modifier.fillMaxWidth(),
        searchQuery = "kotlin",
        onSearchQueryChanged = {},
        onImeSearch = {}
    )
}