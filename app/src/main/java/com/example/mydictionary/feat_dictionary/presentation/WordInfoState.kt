package com.example.mydictionary.feat_dictionary.presentation

import com.example.mydictionary.feat_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)