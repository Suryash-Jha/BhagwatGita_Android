package com.example.bhagwatgita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LanguageSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_select)

        val prefs= this.getSharedPreferences("prefs", MODE_PRIVATE)
        var lang= "hindi"
        val hindiBtn= findViewById<Button>(R.id.hindi)
        val englishBtn= findViewById<Button>(R.id.english)
        val editor= prefs.edit()

        hindiBtn.setOnClickListener{
            lang= "hindi"
            editor.putString("lang", lang)
            editor.apply()
            val i= Intent(this, ChapterListActivity::class.java)
            startActivity(i)
        }
        englishBtn.setOnClickListener{
            lang= "english"
            editor.putString("lang", lang)
            editor.apply()
            val i= Intent(this, ChapterListActivity::class.java)
            startActivity(i)
        }

    }
}