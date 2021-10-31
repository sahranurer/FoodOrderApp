package com.sahraer.yemeksiparisapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.repo.YemeklerDaoRepo

class AnasayfaFragmentViewModel : ViewModel() {

    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    private val ydor = YemeklerDaoRepo()

    init{
        yemeklerYukle()
        yemeklerListesi = ydor.yemekleriGetir()
    }

    fun yemeklerYukle(){
        ydor.tumYemekleriAl()

    }


}