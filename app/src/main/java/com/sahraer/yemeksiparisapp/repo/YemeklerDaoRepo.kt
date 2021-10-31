package com.sahraer.yemeksiparisapp.repo

import androidx.lifecycle.MutableLiveData
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.entity.YemeklerCevap
import com.sahraer.yemeksiparisapp.retrofit.ApiUtils
import com.sahraer.yemeksiparisapp.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepo {
    private  val yemeklerListesi:MutableLiveData<List<Yemekler>>
    private val yemeklerDaoInterface:YemeklerDaoInterface
    init{
        yemeklerDaoInterface = ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    fun tumYemekleriAl(){
        yemeklerDaoInterface.tumYemekler().enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val list = response.body().yemekler
                yemeklerListesi.value = list
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {

            }
        })
    }


}