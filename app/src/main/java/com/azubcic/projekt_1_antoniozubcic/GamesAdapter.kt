package com.azubcic.projekt_1_antoniozubcic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GamesAdapter(
    private val onItemClick: (GameEntity) -> Unit
) : RecyclerView.Adapter<GameViewHolder>() {

    var games: List<GameEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_list_item, parent, false)
        return GameViewHolder(view, onItemClick)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }
}