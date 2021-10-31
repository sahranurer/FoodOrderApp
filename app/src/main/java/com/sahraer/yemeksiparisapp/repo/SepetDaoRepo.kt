package com.sahraer.yemeksiparisapp.repo

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.sahraer.yemeksiparisapp.entity.*
import com.sahraer.yemeksiparisapp.retrofit.ApiUtils
import com.sahraer.yemeksiparisapp.retrofit.SepetDaoInterface
import com.sahraer.yemeksiparisapp.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SepetDaoRepo {

    private val sepetListesi:MutableLiveData<List<Sepet>>
    private val sepetDaoInterface:SepetDaoInterface


    init{
        sepetDaoInterface = ApiUtils.getSepetDaoInterface()
        sepetListesi = MutableLiveData()
    }

    fun tumSepettekilerGetir() : MutableLiveData<List<Sepet>>{
        return sepetListesi
    }



    fun tumSepettekilerAl(){

        sepetDaoInterface.tumSepettekiYemekler("SahranurEr").enqueue( object : Callback<SepetCevap> {
            override fun onResponse(call: Call<SepetCevap>, response: Response<SepetCevap>) {
                val list = response.body().sepet_yemekler

                Log.e("burada",list.size.toString())
                sepetListesi.value = list
            }



            override fun onFailure(call: Call<SepetCevap>?, t: Throwable?) {

            }
        })



    }

    fun yemekSil(yemek_id:Int){
       sepetDaoInterface.sepetttenYemekSil(yemek_id).enqueue(object : Callback<CRUDCevap>{
           override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
               Log.e("başarılı silme işlemi", response.body()?.success.toString())
               Log.e("mesaj", response.body()?.message.toString())
               tumSepettekilerAl()
           }

           override fun onFailure(call: Call<CRUDCevap>, t: Throwable?) {

           }
       })
   }





 fun yemekSepetEkle(yemek_id: Int, yemek_adi: String, yemek_resim_adi: String, yemek_fiyat: Int,yemek_siparis_adet:Int,kullanici_adi:String){
        Log.e("mesaj burada","buraya girdi")
        sepetDaoInterface.yemekEkle(yemek_id,
            yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object:Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                Log.e("başarı", response.body()?.success.toString())
                Log.e("mesaj", response.body()?.message.toString())

            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }

        })
    }




}