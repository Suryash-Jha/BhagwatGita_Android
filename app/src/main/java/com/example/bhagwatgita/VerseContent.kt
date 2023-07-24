package com.example.bhagwatgita

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bhagwatgita.models.GetParticularVerse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class VerseContent : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View  =  inflater.inflate(R.layout.fragment_verse_content, container, false)
        var sanskritShlokview= view!!.findViewById<TextView>(R.id.verse_sanskrit)
        var translationview= view!!.findViewById<TextView>(R.id.verse_translation)
        var chapXverseView= view!!.findViewById<TextView>(R.id.chapXverse)

        // Inflate the layout for this fragment
        val obj= ApiCall()
        var chap=1
        var verse=1

        GlobalScope.launch(Dispatchers.IO) {
            val resp = obj.getParticularVerse(1,4).body!!.string()
            GlobalScope.launch(Dispatchers.Main) {

            val gson = Gson().fromJson<GetParticularVerse>(resp, GetParticularVerse::class.java)
            sanskritShlokview.text= gson.text
            translationview.text= gson.translations?.get(0)?.description
            chap= gson.chapter_number!!
                verse= gson.verse_number!!
                chapXverseView.text= "Chapter ${chap} Verse ${verse}"

            }
        }


            return view
    }


}