package com.example.bhagwatgita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.bhagwatgita.models.GetAllVerses
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.TranslationsItemx

class VerseAdapter(private var verses: List<GetAllVersesItem>) : RecyclerView.Adapter<VerseAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val chapXVerse= itemView.findViewById<TextView>(R.id.chapXverse)
        val verse_sanskrit= itemView.findViewById<TextView>(R.id.verse_sanskrit)
        val verse_translation= itemView.findViewById<TextView>(R.id.verse_translation)

        init{
            verse_sanskrit.setOnClickListener{
                val position= adapterPosition
                Toast.makeText(itemView.context, "You clicked ${position+1}", Toast.LENGTH_SHORT).show()

            }

        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerseAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_verse_content, parent, false))
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.verse_sanskrit.text= verses.get(position).text
        holder.verse_translation.text= getHindiTranslation(verses.get(position).translations) ?:"Not found"
        holder.chapXVerse.text= "Chapter ${verses.get(position).chapter_number.toString()} Verse ${verses.get(position).verse_number.toString()}"

    }

    private fun getHindiTranslation(translations: List<TranslationsItemx?>?): CharSequence? {
        translations?.forEach{
            if(it?.language == "hindi") return it.description
        }
        return translations?.get(0)?.description
    }

    override fun getItemCount(): Int {
        return verses.size
    }

}