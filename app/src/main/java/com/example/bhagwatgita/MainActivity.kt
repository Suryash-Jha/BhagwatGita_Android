package com.example.bhagwatgita

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.viewpager2.widget.ViewPager2
import com.example.bhagwatgita.models.GetAllVerses
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.GetParticularChap
import com.example.bhagwatgita.models.GetParticularVerse
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.gson.Gson
import getJsonDataFromAsset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import startSound

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var obj= ApiCall()
        val chap= intent.getIntExtra("chap", 1)
        val verses_Json= getJsonDataFromAsset(this, "Chap_${chap}.json")
        val verseList: List<GetAllVersesItem> = Gson().fromJson(verses_Json.toString(), Array<GetAllVersesItem>::class.java).toList()
        val view_pager2= findViewById<ViewPager2>(R.id.view_pager2)
//        val editText= findViewById<EditText>(R.id.editVerse)
        view_pager2.adapter= VerseAdapter(verseList, view_pager2)
        view_pager2.orientation= ViewPager2.ORIENTATION_VERTICAL



//        editText.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {}
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//            }
//
//            override fun onTextChanged(
//                s: CharSequence, start: Int,
//                before: Int, count: Int
//            ) {
//                view_pager2.setCurrentItem(Integer.parseInt(s as String),true)
//            }
//        })

//        editText.setOnClickListener {
//            Toast.makeText(this, editText.text.toString(), Toast.LENGTH_SHORT).show()
//        }

//        homeBtn.setOnClickListener{
//            supportFragmentManager.commit {
//                replace<VerseContent>(R.id.)
//            }
//        }


    }
}