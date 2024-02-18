package com.example.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.ActivityMainBinding

class MainActivity<Button> : AppCompatActivity() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.newGame.setOnClickListener(){
            viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
            viewModel.gameOver(true)
            Log.d("MainActivity", "Started gamed")
        }


    }
}
