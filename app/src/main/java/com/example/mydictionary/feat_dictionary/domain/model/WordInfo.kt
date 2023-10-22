package com.example.mydictionary.feat_dictionary.domain.model

import com.example.mydictionary.feat_dictionary.data.remote.dto.LicenseDto
import com.example.mydictionary.feat_dictionary.data.remote.dto.MeaningDto
import com.example.mydictionary.feat_dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)