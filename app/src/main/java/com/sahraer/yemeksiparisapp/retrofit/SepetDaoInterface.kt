package com.sahraer.yemeksiparisapp.retrofit

import com.sahraer.yemeksiparisapp.entity.CRUDCevap
import com.sahraer.yemeksiparisapp.entity.SepetCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface SepetDaoInterface {

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun tumSepettekiYemekler(@Field("kullanici_adi") kullanici_adi: String): Call<SepetCevap>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepetttenYemekSil(@Field("yemek_id") yemek_id:Int):Call<CRUDCevap>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun yemekEkle(@Field("yemek_id") yemek_id:Int,
                  @Field("yemek_adi") yemek_adi:String,
                  @Field("yemek_resim_adi") yemek_resim_adi:String,
                  @Field("yemek_fiyat") yemek_fiyat:Int,
                  @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                  @Field("kullanici_adi") kullanici_adi:String):Call<CRUDCevap>






}