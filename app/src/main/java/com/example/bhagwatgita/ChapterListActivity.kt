package com.example.bhagwatgita

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.GetChapListItem
import com.google.gson.Gson
import getJsonDataFromAsset

class ChapterListActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_list)
        val chap_Json= getJsonDataFromAsset(this, "Json_ChapList.json")
        val chapList: List<GetChapListItem> = Gson().fromJson(chap_Json.toString(), Array<GetChapListItem>::class.java).toList()
//        Log.d("resp", chapList.toString())
        val recycleViewChap= findViewById<RecyclerView>(R.id.recycleViewChap)
        recycleViewChap.adapter= ChapterAdapter(chapList)
        recycleViewChap.layoutManager= LinearLayoutManager(this)
//        Log.d("resp", chap_Json.toString())

    }
}