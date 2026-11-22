package com.example.aliftaufiq_3tib.Home.anyaman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aliftaufiq_3tib.R
import com.example.aliftaufiq_3tib.databinding.FragmentAnyTunggalBinding


class AnyTunggalFragment : Fragment() {

    private var _binding: FragmentAnyTunggalBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnyTunggalBinding.inflate(inflater, container, false)
        return binding.root
    }
    private val Anyamanlist = listOf(
        Anyamanmodel("Tas Anyaman Rotan Bulat", "Rp 285.000", "https://images.unsplash.com/photo-1590874103328-eac38a683ce7?w=400"),
        Anyamanmodel("Keranjang Anyaman Bambu", "Rp 145.000", "https://images.unsplash.com/photo-1513519245088-0e12902e5a38?w=400"),
        Anyamanmodel("Topi Anyaman Pandan", "Rp 95.000", "https://images.unsplash.com/photo-1521369909029-2afed882baee?w=400"),
        Anyamanmodel("Lampu Gantung Rotan Estetik", "Rp 340.000", "https://images.unsplash.com/photo-1513506003901-1e6a229e2d15?w=400"),
        Anyamanmodel("Kain Tenun Songket Riau", "Rp 850.000", "https://images.unsplash.com/photo-1528459801416-a9e53bbf4e17?w=400"),
        Anyamanmodel("Dompet Anyaman Eceng Gondok", "Rp 110.000", "https://images.unsplash.com/photo-1584917865442-de89df76afd3?w=400"),
        Anyamanmodel("Kursi Santai Rotan Sintetis", "Rp 1.250.000", "https://images.unsplash.com/photo-1592078615290-033ee584e267?w=400"),
        Anyamanmodel("Tikar Pandan Motif Tradisional", "Rp 180.000", "https://images.unsplash.com/photo-1575414003591-ece8d0416c7a?w=400"),
        Anyamanmodel("Tempat Tisu Anyaman Lidi", "Rp 65.000", "https://images.unsplash.com/photo-1616486338812-3dadae4b4ace?w=400"),
        Anyamanmodel("Tas Tote Kanvas Lukis Tangan", "Rp 135.000", "https://images.unsplash.com/photo-1544816155-12df9643f363?w=400"),
        Anyamanmodel("Vas Bunga Keramik Handmade", "Rp 175.000", "https://images.unsplash.com/photo-1578500494198-246f612d3b3d?w=400"),
        Anyamanmodel("Set Cangkir Tanah Liat", "Rp 210.000", "https://images.unsplash.com/photo-1514228742587-6b1558fcca3d?w=400"),
        Anyamanmodel("Hiasan Dinding Makrame", "Rp 160.000", "https://images.unsplash.com/photo-1522758971460-1d21eed7dc1d?w=400"),
        Anyamanmodel("Nampan Saji Kayu Jati", "Rp 125.000", "https://images.unsplash.com/photo-1610701596007-11502861dcfa?w=400"),
        Anyamanmodel("Kipas Tangan Bambu Batik", "Rp 45.000", "https://images.unsplash.com/photo-1582738411706-bfc8e691d1c2?w=400"),
        Anyamanmodel("Selendang Batik Tulis", "Rp 420.000", "https://images.unsplash.com/photo-1606760227091-3dd870d97f1d?w=400"),
        Anyamanmodel("Kotak Perhiasan Ukiran Kayu", "Rp 195.000", "https://images.unsplash.com/photo-1589834390005-5d4fb9bf3d32?w=400"),
        Anyamanmodel("Sandal Etnik Anyaman Mendong", "Rp 85.000", "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"),
        Anyamanmodel("Cermin Dinding Bingkai Rotan", "Rp 290.000", "https://images.unsplash.com/photo-1618220179428-22790b461013?w=400"),
        Anyamanmodel("Piring Lidi Anyaman (1 Lusin)", "Rp 120.000", "https://images.unsplash.com/photo-1603199506016-b9a594b593c0?w=400"),
        Anyamanmodel("Tudung Saji Anyaman Bambu", "Rp 115.000", "https://images.unsplash.com/photo-1596462502278-27bfdc403348?w=400"),
        Anyamanmodel("Gantungan Kunci Rajut Amigurumi", "Rp 35.000", "https://images.unsplash.com/photo-1615486511484-92e172cc4fe0?w=400"),
        Anyamanmodel("Taplak Meja Tenun Ikat", "Rp 240.000", "https://images.unsplash.com/photo-1584992236310-6edddc08acff?w=400"),
        Anyamanmodel("Keranjang Laundry Rotan Besar", "Rp 310.000", "https://images.unsplash.com/photo-1595515106969-1ce29566ff1c?w=400"),
        Anyamanmodel("Lilin Aromaterapi Wadah Batok", "Rp 75.000", "https://images.unsplash.com/photo-1602874801007-bd458bb1b8b6?w=400"),
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Anyamanadapter = ProAnyAdapter(Anyamanlist) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvProducts.apply {
//             Mode Grid 2 kolom
             layoutManager = GridLayoutManager(requireContext(), 2)

//            // Mode Linear
//            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
           adapter = Anyamanadapter
        }
    }


}
