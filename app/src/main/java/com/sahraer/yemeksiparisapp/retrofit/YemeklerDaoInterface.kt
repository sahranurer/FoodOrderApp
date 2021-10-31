package com.sahraer.yemeksiparisapp.retrofit

import com.sahraer.yemeksiparisapp.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDaoInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>
}