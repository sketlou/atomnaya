package com.example.halloffame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.halloffame.databinding.DetailsActivityBinding

class VeteranDetailsActivity : AppCompatActivity() {

    private lateinit var binding: DetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val image = intent.extras?.getInt("image")
        val description = intent.extras?.getString("description")
        if (image != null) {
            binding.detailsImage.setImageResource(image)
        }
        binding.detailsText.text = description
    }

    companion object {
        private const val VETERAN_IMAGE = "image"
        private const val VETERAN_DESCRIPTION = "description"

        fun getStartIntent(
            context: Context,
            image: Int,
            description: String
        ) = Intent(context, VeteranDetailsActivity::class.java).apply {
            putExtra(VETERAN_IMAGE, image)
            putExtra(VETERAN_DESCRIPTION, description)
        }
    }
}