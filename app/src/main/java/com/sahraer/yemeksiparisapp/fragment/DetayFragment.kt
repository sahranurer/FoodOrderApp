package com.sahraer.yemeksiparisapp.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.sahraer.yemeksiparisapp.R
import com.sahraer.yemeksiparisapp.databinding.FragmentDetayBinding
import com.sahraer.yemeksiparisapp.entity.CRUDCevap
import com.sahraer.yemeksiparisapp.entity.Sepet
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.retrofit.ApiUtils
import com.sahraer.yemeksiparisapp.viewmodel.DetayFragmentViewModel
import kotlinx.android.synthetic.main.fragment_detay.*
import kotlinx.android.synthetic.main.fragment_detay.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetayFragment : Fragment() {

    private lateinit var tasarim: FragmentDetayBinding
    private lateinit var viewModel: DetayFragmentViewModel
    private var yemekId = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container, false)
        tasarim.detayYemekFragment = this

        val bundle:DetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemekNesne
        tasarim.yemekNesnesi = gelenYemek



        var siparisadet = 0
         tasarim.textViewGosterge.text = siparisadet.toString()

        tasarim.detayButtonEkle.setOnClickListener {

            siparisadet +=1
            tasarim.textViewGosterge.text = siparisadet.toString()
        }
        tasarim.detayButtonAzalt.setOnClickListener {
            if (siparisadet>=1){
                siparisadet -= 1
                tasarim.textViewGosterge.text = siparisadet.toString()

            }
        }



         tasarim.geriDonAnasayfa.setOnClickListener {
              Navigation.findNavController(it).navigate(R.id.anasayfaGecis)
          }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun sepeteekle(yemekNesne:Yemekler,adet:String){

        viewModel.yemekSepetEkle(yemekNesne.yemek_id,
            yemekNesne.yemek_adi,
            yemekNesne.yemek_resim_adi,yemekNesne.yemek_fiyat,adet.toInt(),"SahranurEr")



    }










    }





