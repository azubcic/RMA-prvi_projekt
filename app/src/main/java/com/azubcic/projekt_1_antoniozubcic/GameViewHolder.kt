package com.azubcic.projekt_1_antoniozubcic

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameViewHolder(
    private val itemView: View,
    private val onItemClick: (GameEntity) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    fun bind(entity: GameEntity) {
        val tvTitle = itemView.findViewById<TextView>(R.id.game_title)
        tvTitle.text = entity.title
        itemView.setOnClickListener { onItemClick(entity) }
    }
}
