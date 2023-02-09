package com.idn.tugas_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.tugas_1.data.Gambar
import com.idn.tugas_1.databinding.RowBinding

class GambarAdapter(private val Gambar: ArrayList<Gambar>) : RecyclerView.Adapter<GambarAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(RowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun getItemCount(): Int {
        return Gambar.size
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int){
        val(name, photo) = Gambar[position]


        holder.binding.textView.text = name
        holder.binding.imgItemPhoto.setImageResource(photo)
    }
}