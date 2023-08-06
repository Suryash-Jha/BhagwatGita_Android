package com.example.bhagwatgita

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.bhagwatgita.models.GetAllVerses
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.TranslationsItemx
import startSound

class VerseAdapter(private var verses: List<GetAllVersesItem>, private var view_pager2 : ViewPager2) : RecyclerView.Adapter<VerseAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val chapXVerse= itemView.findViewById<TextView>(R.id.chapXverse)
        val verse_sanskrit= itemView.findViewById<TextView>(R.id.verse_sanskrit)
        val verse_translation= itemView.findViewById<TextView>(R.id.verse_translation)
        val editText= itemView.findViewById<EditText>(R.id.editVerse)
        val versePlayer= itemView.findViewById<ImageButton>(R.id.play_verse)
        val backBtn= itemView.findViewById<ImageButton>(R.id.back)
        val nextBtn= itemView.findViewById<ImageButton>(R.id.next)
        val prevBtn= itemView.findViewById<ImageButton>(R.id.prev)

//        var x= "1"

//        val view_pager2= itemView.findViewById<ViewPager2>(R.id.view_pager2)

        init{
            verse_sanskrit.setOnClickListener{
                val position= adapterPosition
                Toast.makeText(itemView.context, "You clicked ${position+1}", Toast.LENGTH_SHORT).show()

            }
            editText.setOnClickListener {
                if(editText.getText().toString().isEmpty())
                    view_pager2.setCurrentItem(0,true)
                else{
                    val s= Integer.parseInt(editText.text.toString())

                    view_pager2.setCurrentItem(s-1 ,true)
                }

            }
            versePlayer.setOnClickListener {
                startSound( "1/1.mp3", itemView.context)

            }
            backBtn.setOnClickListener{
                val i= Intent(itemView.context, ChapterListActivity::class.java)
                itemView.context.startActivity(i)
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
        holder.chapXVerse.text= "Chapter ${verses.get(position).chapter_number.toString()} Verse "
        holder.editText.setText((position+1).toString())
        holder.nextBtn.setOnClickListener {
            view_pager2.setCurrentItem(position+1 ,true)
        }
        holder.prevBtn.setOnClickListener {
            view_pager2.setCurrentItem(position-1 ,true)
        }


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