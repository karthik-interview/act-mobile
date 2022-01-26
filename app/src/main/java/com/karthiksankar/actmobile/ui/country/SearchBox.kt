package com.karthiksankar.actmobile.ui.country

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.karthiksankar.actmobile.R


@Composable
fun SearchBox(
    query: String,
    placeholder: String,
    onQueryChange: (String) -> Unit,
    clearSearch: () -> Unit,
    onDone: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(text = placeholder)
        },
        shape = RoundedCornerShape(0.dp),
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = clearSearch) {
                    Icon(
                        imageVector = Icons.TwoTone.Clear,
                        contentDescription = stringResource(id = R.string.cd_clear_search)
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDone() }),
        modifier = modifier,
    )
}
