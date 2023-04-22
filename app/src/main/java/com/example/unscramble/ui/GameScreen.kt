package com.example.unscramble.ui

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramble.ui.theme.UnScrambleTheme


@Composable
fun GameScreen (modifier: Modifier = Modifier) {

    Column(

        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp)


    ) {

        GameStatus()
        GameLayout()

    }
}

@Composable
fun GameStatus (modifier: Modifier = Modifier) {

    Row(

        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(48.dp)

    ) {

        Text(
            text = stringResource(com.example.unscramble.R.string.word_count, 1),
            fontSize = 18.sp
        )

        Text(

            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                    ,

            text = stringResource(com.example.unscramble.R.string.score,0),
            fontSize = 18.sp)

    }
}

@Composable
fun GameLayout (modifier: Modifier = Modifier) {


    Column(

        verticalArrangement = Arrangement.spacedBy(24.dp)

    ) {

        Text(
            text = "scrambleun",
            fontSize = 45.sp,
            modifier =Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(com.example.unscramble.R.string.instructions),
            fontSize = 17.sp,
            modifier =Modifier.align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(

            value = " ",
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { },
            label = { Text(stringResource(id = com.example.unscramble.R.string.enter_your_word)) },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { }
            )

        )




    }
}

@Composable
private fun FinalScoreDialog (

    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier

) {

    val activity = (LocalContext.current as Activity)

    AlertDialog(

        onDismissRequest = { /**/ },
        title = { Text(stringResource(com.example.unscramble.R.string.congratulations))},
        text = { Text(stringResource(com.example.unscramble.R.string.you_scored))},
        modifier = modifier,
        dismissButton = {

                        TextButton(
                            onClick = { activity.finish() }) {
                            Text(text = stringResource(com.example.unscramble.R.string.exit))
                        }
        },
        confirmButton = {

            TextButton(
                onClick = { onPlayAgain }) {
                Text(text = stringResource(com.example.unscramble.R.string.play_again))
            }

        }

        )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    UnScrambleTheme() {

        GameScreen()

    }
}