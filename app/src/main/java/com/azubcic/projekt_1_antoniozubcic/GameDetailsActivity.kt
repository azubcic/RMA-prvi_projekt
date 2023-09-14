package com.azubcic.projekt_1_antoniozubcic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameDetailsActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)

        connectViews()
        applyDetails()
    }

    private fun applyDetails() {
        val entity = intent.getSerializableExtra("game") as? GameEntity

        entity?.let {
            tvTitle.text = it.title
            tvDescription.text = it.short_description
        }

        btnBack.setOnClickListener { finish() }
    }

    private fun connectViews() {
        tvTitle = findViewById(R.id.tvTitle)
        tvDescription = findViewById(R.id.tvDescription)
        btnBack = findViewById(R.id.btnBack)
    }
}