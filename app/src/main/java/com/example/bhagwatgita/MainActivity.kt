package com.example.bhagwatgita

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var homeBtn= findViewById<Button>(R.id.home)
        var scrollBtn= findViewById<Button>(R.id.scroll)
        var loginBtn= findViewById<Button>(R.id.login)

        homeBtn.setOnClickListener{
            supportFragmentManager.commit {
                replace<BlankFragment>(R.id.placeholder)
            }
        }
        scrollBtn.setOnClickListener{
            supportFragmentManager.commit {
                replace<Scroll>(R.id.placeholder)
            }
        }
        loginBtn.setOnClickListener{
            supportFragmentManager.commit {
                replace<Login>(R.id.placeholder)
            }
        }

    }
}