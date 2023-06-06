package com.example.halloffame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.halloffame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val veteranList = listOf(
            Veteran(
                id = 1,
                name = resources.getString(R.string.haritov),
                image = R.drawable.pic1,
                description = resources.getString(R.string.haritov_description)
            ),
            Veteran(
                id = 2,
                name = resources.getString(R.string.kurchatov),
                image = R.drawable.pic2,
                description = resources.getString(R.string.kurchatov_description)
            ),
            Veteran(
                id = 3,
                name = resources.getString(R.string.hlopin),
                image = R.drawable.pic3,
                description = resources.getString(R.string.hlopin_description)
            ),
            Veteran(
                id = 4,
                name = resources.getString(R.string.saharov),
                image = R.drawable.pic4,
                description = resources.getString(R.string.saharov_description)
            ),
            Veteran(
                id = 5,
                name = resources.getString(R.string.budker),
                image = R.drawable.pic5,
                description = resources.getString(R.string.budker_description)
            ),
            Veteran(
                id = 6,
                name = resources.getString(R.string.keldysh),
                image = R.drawable.pic6,
                description = resources.getString(R.string.keldysh_description)
            ),
            Veteran(
                id = 7,
                name = resources.getString(R.string.zababahin),
                image = R.drawable.pic7,
                description = resources.getString(R.string.zababahin_description)
            ),
            Veteran(
                id = 8,
                name = resources.getString(R.string.vasiliev),
                image = R.drawable.pic8,
                description = resources.getString(R.string.vasiliev_description)
            ), Veteran(
                id = 9,
                name = resources.getString(R.string.brish),
                image = R.drawable.pic9,
                description = resources.getString(R.string.brish_description)
            ),
            Veteran(
                id = 10,
                name = resources.getString(R.string.sobolev),
                image = R.drawable.pic10,
                description = resources.getString(R.string.sobolev_description)
            )
        )
        val mAdapter = VeteranListAdapter(this::onItemClicked)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = mAdapter
        mAdapter.submitList(veteranList)
    }

    private fun onItemClicked(veteran: Veteran) {
        startActivity(
            VeteranDetailsActivity.getStartIntent(
                this,
                veteran.image,
                veteran.description
            )
        )
    }
}