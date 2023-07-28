package com.example.bhagwatgita

import android.content.Context
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.GetChapListItem
import com.google.gson.Gson
import getJsonDataFromAsset
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response as Response1

class ApiCall {

// particular verse
    fun getParticularVerse(chap: Int, verse: Int): Response1 {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://bhagavad-gita3.p.rapidapi.com/v2/chapters/${chap}/verses/${verse}/")
            .get()
            .addHeader("X-RapidAPI-Key", "273f74489fmsh5eaa5aca7dac36cp1d24c4jsn7ebe1b17a6c4")
            .addHeader("X-RapidAPI-Host", "bhagavad-gita3.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        //        Log.d("resp", response.body!!.string())
        return response

    }




//// all verse'
    fun getAllVerses(chap: Int): Response1 {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://bhagavad-gita3.p.rapidapi.com/v2/chapters/${chap}/verses/")
            .get()
            .addHeader("X-RapidAPI-Key", "273f74489fmsh5eaa5aca7dac36cp1d24c4jsn7ebe1b17a6c4")
            .addHeader("X-RapidAPI-Host", "bhagavad-gita3.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
    return response

    }


//
////    particular chapter
    fun getParticularChap(chap: Int): Response1 {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://bhagavad-gita3.p.rapidapi.com/v2/chapters/${chap}/")
            .get()
            .addHeader("X-RapidAPI-Key", "273f74489fmsh5eaa5aca7dac36cp1d24c4jsn7ebe1b17a6c4")
            .addHeader("X-RapidAPI-Host", "bhagavad-gita3.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        return response

}

//    Get all verses Faster


////    get all chap
    fun getAllChap(): Response1 {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://bhagavad-gita3.p.rapidapi.com/v2/chapters/?limit=18")
            .get()
            .addHeader("X-RapidAPI-Key", "273f74489fmsh5eaa5aca7dac36cp1d24c4jsn7ebe1b17a6c4")
            .addHeader("X-RapidAPI-Host", "bhagavad-gita3.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
    return response

}


}