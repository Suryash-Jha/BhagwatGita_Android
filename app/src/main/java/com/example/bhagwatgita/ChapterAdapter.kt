package com.example.bhagwatgita

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bhagwatgita.models.GetChapListItem

class ChapterAdapter(private var chapList: List<GetChapListItem>) :  RecyclerView.Adapter<ChapterAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val numberXtitle= view.findViewById<TextView>(R.id.numberXtitle)
        val versesCount= view.findViewById<TextView>(R.id.versesCount)

        init{
            numberXtitle.setOnClickListener {
                val position= adapterPosition
                val i= Intent(view.context, MainActivity::class.java)
                i.putExtra("chap", position+1)
                Toast.makeText(view.context, "Opening Chapter ${position + 1}", Toast.LENGTH_SHORT).show()
                view.context.startActivity(i)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chapview, parent, false))

    }

    override fun getItemCount(): Int {
        return chapList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numberXtitle.text = "${position+1} : ${chapList[position].name}"
        holder.versesCount.text= "${chapList[position].verses_count}"
    }


}