package com.example.mydictionary.feat_dictionary.domain.use_case

import com.example.mydictionary.core.util.Resource
import com.example.mydictionary.feat_dictionary.domain.model.WordInfo
import com.example.mydictionary.feat_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(
    private val repository: WordInfoRepository
) {
    // call the class as a function
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>>{
        return if(word.isBlank()){
            flow {}
        } else{
            repository.getWordInfo(word)
        }
    }
}