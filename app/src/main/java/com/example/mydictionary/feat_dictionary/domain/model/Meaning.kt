package com.example.mydictionary.feat_dictionary.domain.model

import com.example.mydictionary.feat_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String,
)