package com.idn.tugas_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idn.tugas_1.adapter.GambarAdapter
import com.idn.tugas_1.data.Gambar
import com.idn.tugas_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Gambar>()
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }
    private fun getListHeroes(): ArrayList<Gambar> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPhoto = ArrayList<Gambar>()
        for(i in dataName.indices){
            val photo = Gambar(dataName[i], dataPhoto.getResourceId(i, -1))
            listPhoto.add(photo)
        }
        return  listPhoto
    }

    private fun showRecyclerList(){
        binding.rvHeroes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listHeroAdapter = GambarAdapter(list)
        binding.rvHeroes.adapter = listHeroAdapter
    }
}