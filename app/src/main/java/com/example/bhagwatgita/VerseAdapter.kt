package com.example.bhagwatgita

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bhagwatgita.models.GetAllVersesItem
import com.example.bhagwatgita.models.TranslationsItemx
import startSound

class VerseAdapter(private var verses: List<GetAllVersesItem>, private var view_pager2 : ViewPager2) : RecyclerView.Adapter<VerseAdapter.Pager2ViewHolder>() {
    var mMediaPlayer: MediaPlayer? = null

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val chapXVerse= itemView.findViewById<TextView>(R.id.chapXverse)
        val verse_sanskrit= itemView.findViewById<TextView>(R.id.verse_sanskrit)
        val verse_translation= itemView.findViewById<TextView>(R.id.verse_translation)
        val editText= itemView.findViewById<EditText>(R.id.editVerse)
        val versePlayer= itemView.findViewById<ImageButton>(R.id.play_verse)
        val backBtn= itemView.findViewById<ImageButton>(R.id.back)
        val nextBtn= itemView.findViewById<ImageButton>(R.id.next)
        val prevBtn= itemView.findViewById<ImageButton>(R.id.prev)
        val likeBtn= itemView.findViewById<ImageButton>(R.id.liked)
        val playBtn= itemView.findViewById<ImageButton>(R.id.play_verse)
        val ctx= itemView.context

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

            backBtn.setOnClickListener{
                val i= Intent(itemView.context, ChapterListActivity::class.java)
                itemView.context.startActivity(i)
            }



        }

    }

    private fun handleMusic(itemView: View, playBtn: ImageButton?, verse: Int?, chap: Int?) {

        if(mMediaPlayer!= null && mMediaPlayer!!.isPlaying){
            mMediaPlayer?.pause()
            playBtn?.setImageResource(R.drawable.ic_play_music)
        }
        else{
            if(mMediaPlayer== null){
                mMediaPlayer= MediaPlayer.create(itemView.context, itemView.context.resources.getIdentifier("c${chap}v${verse}", "raw", itemView.context.packageName))
                mMediaPlayer!!.start()
            }
            else mMediaPlayer!!.start()
            playBtn?.setImageResource(R.drawable.ic_pause)

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerseAdapter.Pager2ViewHolder {
        val v = Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_verse_content, parent, false))
        return v
    }

    private fun getLikedStatus(chap: Int?, verse: Int?): Any? {
        return "unliked"
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        val chap= verses.get(position).chapter_number
        val verse= verses.get(position).verse_number


        holder.verse_sanskrit.text= verses.get(position).text
        holder.verse_translation.text= getHindiTranslation(verses.get(position).translations) ?:"Not found"
        holder.chapXVerse.text= "Chapter ${chap.toString()} Verse "
        holder.editText.setText((position+1).toString())
        holder.likeBtn.tag= getLikedStatus(chap, verse)
        val pref= holder.ctx.getSharedPreferences("pref", MODE_PRIVATE)
        val editor= pref.edit()
        editor.putInt("arr2", 6)
        editor.apply()
        Log.i("test", pref.all.toString())


        holder.nextBtn.setOnClickListener {
            view_pager2.setCurrentItem(position+1 ,true)
            stopAudio()

        }

        holder.prevBtn.setOnClickListener {
            view_pager2.setCurrentItem(position-1 ,true)
            stopAudio()
        }
        holder.likeBtn.setOnClickListener {
            if(holder.likeBtn.tag== "liked"){
                holder.likeBtn.setImageResource(R.drawable.ic_unliked)
//                removeFromFav(chap, verse)
                holder.likeBtn.tag= "unliked"
                Toast.makeText(holder.ctx, "Removed From Favourites", Toast.LENGTH_SHORT).show()
            }
            else{
                holder.likeBtn.setImageResource(R.drawable.ic_liked)
//                addToFav(chap, verse)
                holder.likeBtn.tag= "liked"
                Toast.makeText(holder.ctx, "Added To Favourites", Toast.LENGTH_SHORT).show()

            }
        }
        holder.versePlayer.setOnClickListener {
            handleMusic(holder.itemView, holder.playBtn, verse, chap)
        }


    }

    private fun stopAudio() {
        if(mMediaPlayer!= null){
            if(mMediaPlayer!!.isPlaying) mMediaPlayer?.pause()
            mMediaPlayer= null

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