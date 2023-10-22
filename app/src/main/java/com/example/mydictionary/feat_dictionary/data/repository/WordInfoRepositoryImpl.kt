package com.example.mydictionary.feat_dictionary.data.repository

import com.example.mydictionary.core.util.Resource
import com.example.mydictionary.feat_dictionary.data.local.WordInfoDao
import com.example.mydictionary.feat_dictionary.data.remote.DictionaryApi
import com.example.mydictionary.feat_dictionary.domain.model.WordInfo
import com.example.mydictionary.feat_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        // Get data from cache
        val wordInfos = dao.getWordInfos(word).map{ it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))


        try{
            // Remove old data and replace with new ones for the SAME WORD (from remote api)
          val remoteWordInfos = api.getWordInfo(word)
          dao.deleteWordInfos(remoteWordInfos.map {it.word ?: ""})
          dao.insertWordInfos(remoteWordInfos.map {it.toWordInfoEntity()})
        } catch (e: HttpException){
            emit(Resource.Error(
                message = "Oops. something went wrong!",
                data = wordInfos
            ))
        } catch (e: IOException){
            emit(Resource.Error(
                message = "Couldn't reach the server. Check your internet connection",
                data = wordInfos
            ))
        }

        // SSOT - fetched data must be saved to into DB and UI only takes data from DB
        val newWordInfos = dao.getWordInfos(word).map{it.toWordInfo()}
        emit(Resource.Success(newWordInfos))
    }
}