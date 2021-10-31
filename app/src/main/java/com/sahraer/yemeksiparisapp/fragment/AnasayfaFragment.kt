package com.sahraer.yemeksiparisapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahraer.yemeksiparisapp.R
import com.sahraer.yemeksiparisapp.adapter.YemeklerAdapter
import com.sahraer.yemeksiparisapp.databinding.FragmentAnasayfaBinding
import com.sahraer.yemeksiparisapp.entity.Yemekler
import com.sahraer.yemeksiparisapp.viewmodel.AnasayfaFragmentViewModel
import kotlinx.android.synthetic.main.fragment_anasayfa.view.*


class AnasayfaFragment : Fragment() {


    private lateinit var adapter: YemeklerAdapter
    private lateinit var yemeklerListesi:ArrayList<Yemekler>
    private lateinit var viewModel:AnasayfaFragmentViewModel
    private lateinit var tasarim :FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        tasarim.anasayfaFragment = this

        viewModel.yemeklerListesi.observe(viewLifecycleOwner,{ yemeklerListesi ->

            adapter = YemeklerAdapter(requireContext(),yemeklerListesi,viewModel)
            tasarim.yemeklerAdapter = adapter
        })


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnasayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun shoppinIconTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.sepetGecis)
    }






}