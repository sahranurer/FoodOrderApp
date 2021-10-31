package com.sahraer.yemeksiparisapp.retrofit

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.google.android.gms.fido.fido2.api.common.RequestOptions
import com.sahraer.yemeksiparisapp.R


class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu"

        fun getYemeklerDaoInterface() : YemeklerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDaoInterface::class.java)
        }

        fun getSepetDaoInterface():SepetDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(SepetDaoInterface::class.java)
        }






    }
}