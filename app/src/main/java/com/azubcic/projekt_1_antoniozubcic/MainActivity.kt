package com.azubcic.projekt_1_antoniozubcic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter: GamesAdapter by lazy { GamesAdapter(this::onItemClick) }


    private val repository: GamesRepository by lazy { GamesRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        GlobalScope.launch(Dispatchers.Main) {
            val games = repository.getGamesFromAPI()
            adapter.games = games
            adapter.notifyDataSetChanged()
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun onItemClick(gameEntity: GameEntity) {
        val intent = Intent(this, GameDetailsActivity::class.java)
        intent.putExtra("game", gameEntity)
        startActivity(intent)
    }
}
