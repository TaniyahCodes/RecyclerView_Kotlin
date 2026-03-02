package com.example.recyclerviewlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewlab.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = generateSampleItems()
        val adapter = ItemAdapter(items)

        binding.itemRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            this.adapter = adapter
        }
    }

    private fun generateSampleItems(): List<SampleItem> {
        return (1..20).map { index ->
            SampleItem(
                title = getString(R.string.item_title, index),
                subtitle = getString(R.string.item_subtitle, index)
            )
        }
    }
}