package com.example.musicplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(var musicList: MutableList<Music>, var itemClicked: ItemClicked): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.MusicViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(R.layout.music_item, parent, shouldAttachToParentImmediately)

        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicAdapter.MusicViewHolder, position: Int) {
        val item = musicList[position]

        holder.bindMusic(item)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }




    inner class MusicViewHolder(v : View) : RecyclerView.ViewHolder(v) , View.OnClickListener {

        private var view: View = v
        private lateinit var music: Music
        private var artistName: TextView
        private var songName: TextView

        init {
            artistName = view.findViewById(R.id.artist_text_view)
            songName = view.findViewById(R.id.song_text_view)
            view.setOnClickListener(this)
        }
        fun bindMusic(music: Music) {
            this.music = music

            artistName.text = music.artistName
            songName.text = music.songName
               }

        override fun onClick(p0: View?) {
            itemClicked.itemClicked(adapterPosition)        }
    }

}
