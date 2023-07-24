package com.example.bhagwatgita

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.GetParticularChap
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        homeBtn.setOnClickListener{
            supportFragmentManager.commit {
                replace<VerseContent>(R.id.placeholder)
            }
//        }


    }
}