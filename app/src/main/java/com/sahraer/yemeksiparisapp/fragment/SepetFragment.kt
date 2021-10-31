package com.sahraer.yemeksiparisapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahraer.yemeksiparisapp.R
import com.sahraer.yemeksiparisapp.adapter.SepetAdapter
import com.sahraer.yemeksiparisapp.adapter.YemeklerAdapter
import com.sahraer.yemeksiparisapp.databinding.FragmentSepetBinding
import com.sahraer.yemeksiparisapp.entity.Sepet
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.viewmodel.DetayFragmentViewModel
import com.sahraer.yemeksiparisapp.viewmodel.SepetFragmentViewModel
import kotlinx.android.synthetic.main.fragment_sepet.*

class SepetFragment : Fragment() {

    private lateinit var adapter: SepetAdapter
    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var viewModel: SepetFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false)
        tasarim.sepetFragment = this

        viewModel.sepetyemeklerListesi.observe(viewLifecycleOwner,{ sepetListesi ->
            Log.e("sepette",sepetListesi.size.toString())
            adapter = SepetAdapter(requireContext(),sepetListesi,viewModel)
            tasarim.sepetAdapter = adapter

        })
       tasarim.buttonSepet.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_sepetFragment_to_anasayfaFragment)
        }




        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        setHasOptionsMenu(true)
        val tempViewModel:SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }


}