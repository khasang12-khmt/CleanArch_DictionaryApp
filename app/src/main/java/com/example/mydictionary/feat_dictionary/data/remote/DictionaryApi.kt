package com.example.mydictionary.feat_dictionary.data.remote

import com.example.mydictionary.feat_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

class DictionaryApi {
    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>{
        return emptyList()
    }
}