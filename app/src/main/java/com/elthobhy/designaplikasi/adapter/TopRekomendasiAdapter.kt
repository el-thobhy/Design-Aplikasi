package com.elthobhy.designaplikasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elthobhy.designaplikasi.data.Paket
import com.elthobhy.designaplikasi.databinding.ListItemBinding
import java.text.NumberFormat
import java.util.*

class TopRekomendasiAdapter(

    private var context: Context,
    private val itemClickListener: OnItemClickListener


) : RecyclerView.Adapter<TopRekomendasiAdapter.ViewHolder>() {

    private val data: MutableList<Paket> = mutableListOf()

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(paketRekomendasi: Paket, itemClickListener: OnItemClickListener)
        {
            val myIndonesianLocale = Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(myIndonesianLocale)
            numberFormat.maximumFractionDigits = 0

            binding.clRecommended.setOnClickListener {
                itemClickListener.onItemClicked(itemView, adapterPosition)
            }

            binding.tvPaket.text = paketRekomendasi.nama_paket
            binding.tvKuota.text = "${paketRekomendasi.kuota} GB"
            binding.tvHarga.text = "${numberFormat.format(paketRekomendasi.harga)}"
            binding.tvDurasi.text = "${paketRekomendasi.durasi} Hari"

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    fun setData(newListData: List<Paket>?) {
        if (newListData == null) return
        data.clear()
        data.addAll(newListData)
        notifyDataSetChanged()
    }

    fun getId(position: Int) : Int{
        return data[position].id
    }

    fun getNamaProduk(position: Int) : String{
        return data[position].nama_paket
    }

    fun getHargaJual(position: Int) : Int{
        return data[position].harga
    }

    fun removeData(){
        data.clear()
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val topRekomendasi = data.get(position)
        holder.bind(topRekomendasi,itemClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickListener{
        fun onItemClicked(v: View, position: Int)
    }
}