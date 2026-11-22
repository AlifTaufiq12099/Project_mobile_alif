package com.example.aliftaufiq_3tib.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.aliftaufiq_3tib.Home.Pertemuan5.LimaActivity
import com.example.aliftaufiq_3tib.Home.Pertemuan5.WebViewActivity
import com.example.aliftaufiq_3tib.Home.anyaman.AnyamanActivity
import com.example.aliftaufiq_3tib.Home.fragment.SixthActivity
import com.example.aliftaufiq_3tib.LoginActivity
import com.example.aliftaufiq_3tib.activity_detail
import com.example.aliftaufiq_3tib.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val pass = requireActivity().intent.getStringExtra("Pass")
        val umur = requireActivity().intent.getIntExtra("Umur", 0)
        val user = sharedPref.getString("username", "Pengguna")

        Log.e("Hasil", "Umur $umur")
        binding.textView3.text = "Selamat Datang, $user!\ndi Kriyaku"

//        binding.btnSnackBar.setOnClickListener {
//            Snackbar.make(binding.root, "Item dihapus", Snackbar.LENGTH_LONG)
//                .setAction("BATAL") {
//                    // Pake requireContext()
//                    val intent = Intent(requireContext(), LoginActivity::class.java)
//                    startActivity(intent)
//                }
//                .show()
//        }
////
//        binding.AlertDialog.setOnClickListener {
//            // Pake requireContext()
//            AlertDialog.Builder(requireContext())
//                .setTitle("Logout")
//                .setMessage("Apakah Anda yakin ingin keluar?")
//                .setPositiveButton("Ya") { dialog, _ ->
//                    val editor = sharedPref.edit()
//                    editor.clear()
//                    editor.apply()
//                    dialog.dismiss()
//
//                    startActivity(Intent(requireContext(), LoginActivity::class.java))
//                    requireActivity().finish() // Pake requireActivity().finish()
//                }
//                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
//                .show()
//        }

        binding.btnlihat.setOnClickListener {
            val intent = Intent(requireContext(), activity_detail::class.java)
            startActivity(intent)
        }

//        binding.btnlihatfragment.setOnClickListener {
//            startActivity(Intent(requireContext(), SixthActivity::class.java))
//        }
        binding.btnAnyaman.setOnClickListener {
            val intent = Intent(requireContext(), AnyamanActivity::class.java)
            startActivity(intent)
        }

        binding.btnlihatweb.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Mencegah memory leak ViewBinding pada Fragment
    }
}