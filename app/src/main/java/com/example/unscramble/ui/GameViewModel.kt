package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState : StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord : String
    private var userWords : MutableSet<String> = mutableSetOf()

    init {

        resetGame()
    }

    private fun pickRandomWordAndShuffle() : String {

        currentWord = allWords.random()

        if (userWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            userWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord (word : String) : String {

        val tempWord = word.toCharArray()

        tempWord.shuffle()

        while (String(tempWord).equals(word))
            tempWord.shuffle()

        return String(tempWord)
    }

    fun resetGame() {
        userWords.clear()
        _uiState.value = GameUiState(currentScrambleWord = pickRandomWordAndShuffle())
    }

}