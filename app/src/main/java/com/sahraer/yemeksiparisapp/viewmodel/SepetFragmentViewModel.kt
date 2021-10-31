package com.sahraer.yemeksiparisapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahraer.yemeksiparisapp.entity.Sepet
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.repo.SepetDaoRepo

class SepetFragmentViewModel : ViewModel() {

    var sepetyemeklerListesi = MutableLiveData<List<Sepet>>()
    private val sdor = SepetDaoRepo()

    fun sil(yemek_id:Int){
        sdor.yemekSil(yemek_id)
    }


     init{
         sepetekilerGoruntule()
         sepetyemeklerListesi = sdor.tumSepettekilerGetir()
    }


    fun sepetekilerGoruntule(){
        Log.e("mesajsepetgörüntüle","viewModel kısmına ulaştı")
        sdor.tumSepettekilerAl()
    }










}