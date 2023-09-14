package com.azubcic.projekt_1_antoniozubcic

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GamesRepository {
    suspend fun getGamesFromAPI(): List<GameEntity> = withContext(Dispatchers.IO) {
        var games: List<GameEntity> = emptyList()

        Log.i("MyTag", "getGames()")
        try {
            val url = URL("https://www.freetogame.com/api/games")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.readTimeout = 15000
            httpURLConnection.connectTimeout = 15000
            httpURLConnection.connect()
            Log.i("MyTag", "http connection")
            val inputStreamReader = InputStreamReader(httpURLConnection.inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val listType = object : TypeToken<List<GameEntity>>() {}.type
            games = Gson().fromJson(bufferedReader, listType)
            Log.i("MyTag", "Gson parse")
            //games = response.games
            Log.i("MyTag", games.toString())
            //Log.i("MyTag", response.games.toString())
            bufferedReader.close()
            inputStreamReader.close()

        } catch (e: Exception) {
            Log.d("MyTag", e.message.toString())
            e.printStackTrace()
        }
        return@withContext games
    }
}

