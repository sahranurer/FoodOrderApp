package com.sahraer.yemeksiparisapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sahraer.yemeksiparisapp.R
import com.sahraer.yemeksiparisapp.databinding.CardSepetBinding
import com.sahraer.yemeksiparisapp.entity.Sepet
import com.sahraer.yemeksiparisapp.fragment.SepetFragmentDirections
import com.sahraer.yemeksiparisapp.viewmodel.DetayFragmentViewModel
import com.sahraer.yemeksiparisapp.viewmodel.SepetFragmentViewModel

class SepetAdapter(var mContext: Context,var sepetList :List<Sepet>, var viewModel:SepetFragmentViewModel)
    : RecyclerView.Adapter<SepetAdapter.cardSepetTasarim>() {

    inner class cardSepetTasarim(cardSepetBinding: CardSepetBinding) : RecyclerView.ViewHolder(cardSepetBinding.root){

        var cardSepetBinding:CardSepetBinding
        init {
            this.cardSepetBinding = cardSepetBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardSepetTasarim {

        val inflater = LayoutInflater.from(mContext)
        val tasarim = DataBindingUtil.inflate<CardSepetBinding>(inflater, R.layout.card_sepet, parent, false)
        return cardSepetTasarim(tasarim)




    }

    override fun onBindViewHolder(holder: cardSepetTasarim, position: Int) {
        val t = holder.cardSepetBinding
        val sepet = sepetList.get(position)

        t.yemeksepetiNesnesi = sepet

        val toplam = sepetList[position].yemek_siparis_adet * sepetList[position].yemek_fiyat

        t.textViewtoplam.text = "${toplam.toString()}₺"

        Log.e("cevap", sepetList[position].yemek_siparis_adet.toString())

        t.imageViewSilYemek.setOnClickListener {
            Snackbar.make(it,"${sepetList[position].yemek_adi} silinsin mi ? ",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(sepetList[position].yemek_id)
                }.show()
        }

 }

    override fun getItemCount(): Int {
          return sepetList.size
    }


}

