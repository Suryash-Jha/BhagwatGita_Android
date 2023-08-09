package com.example.bhagwatgita

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bhagwatgita.models.GetChapListItem
import com.google.gson.Gson
import getJsonDataFromAsset

class ChapterListActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_list)
        val prefs= this.getSharedPreferences("prefs", MODE_PRIVATE)
        val language= prefs.getString("lang", null)
        if(language== null){
            val i= Intent(this, LanguageSelectActivity::class.java)
            startActivity(i)
        }

        val chap_Json= getJsonDataFromAsset(this, "Json_ChapList.json")
        val chapList: List<GetChapListItem> = Gson().fromJson(chap_Json.toString(), Array<GetChapListItem>::class.java).toList()
//        Log.d("resp", chapList.toString())
        val recycleViewChap= findViewById<RecyclerView>(R.id.recycleViewChap)
        recycleViewChap.adapter= ChapterAdapter(chapList)
        recycleViewChap.layoutManager= LinearLayoutManager(this)
//        Log.d("resp", chap_Json.toString())

    }
}