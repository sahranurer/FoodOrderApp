package com.sahraer.yemeksiparisapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sahraer.yemeksiparisapp.R
import com.sahraer.yemeksiparisapp.databinding.CardTasarimBinding
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.fragment.AnasayfaFragmentDirections
import com.sahraer.yemeksiparisapp.viewmodel.AnasayfaFragmentViewModel

class YemeklerAdapter( var mContext:Context,var yemeklerListesi:List<Yemekler>,var viewModel:AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarim>() {

    inner class CardTasarim(cardTasarimBinding: CardTasarimBinding) : RecyclerView.ViewHolder(cardTasarimBinding.root){
        
        var cardTasarimBinding: CardTasarimBinding
        

        init{
            this.cardTasarimBinding = cardTasarimBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarim { //card tasarım bağlandı
        val layoutInflater = LayoutInflater.from(mContext)
       val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarim(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarim, position: Int) {

        val t = holder.cardTasarimBinding
        t.yemekNesnesi = yemeklerListesi[position]

        t.imageViewResim.setImageResource(mContext.resources.getIdentifier(yemeklerListesi[position].yemek_resim_adi,"drawable",mContext.packageName))
        t.textViewYemekFiyat.text = "${yemeklerListesi[position].yemek_fiyat}"



        Log.e("cevap", yemeklerListesi[position].yemek_adi)

        t.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemeklerListesi.get(position))
            Navigation.findNavController(it).navigate(gecis)


        }


    }

    override fun getItemCount(): Int { //veri kümesi adeti belirleme
        return yemeklerListesi.size
    }
}
