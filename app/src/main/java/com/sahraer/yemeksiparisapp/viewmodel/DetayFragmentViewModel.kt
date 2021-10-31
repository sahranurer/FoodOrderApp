package com.sahraer.yemeksiparisapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.sahraer.yemeksiparisapp.entity.CRUDCevap
import com.sahraer.yemeksiparisapp.entity.Sepet
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.fragment.DetayFragmentArgs
import com.sahraer.yemeksiparisapp.repo.SepetDaoRepo
import com.sahraer.yemeksiparisapp.repo.YemeklerDaoRepo
import com.sahraer.yemeksiparisapp.retrofit.ApiUtils
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetayFragmentViewModel : ViewModel() {


    private val sdor = SepetDaoRepo()



  fun yemekSepetEkle(yemek_id: Int, yemek_adi: String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int,kullanici_adi: String){
        Log.e("mesaj yemek","viewModel kısmına ulaştı")
        sdor.yemekSepetEkle(yemek_id, yemek_adi.toString(),  yemek_resim_adi.toString(), yemek_fiyat, yemek_siparis_adet,kullanici_adi)
    }
}













