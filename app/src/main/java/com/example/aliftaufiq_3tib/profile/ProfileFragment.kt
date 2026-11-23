package com.example.aliftaufiq_3tib.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.aliftaufiq_3tib.LoginActivity
import com.example.aliftaufiq_3tib.databinding.FragmentProfileBinding
import com.example.aliftaufiq_3tib.databinding.ItemProfileMenuBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Profil Saya"

        val sharedPref = requireActivity()
            .getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val user = sharedPref.getString("username", "Pengguna") ?: "Pengguna"

        binding.tvName.text = user
        binding.tvUsername.text = user

        val menuItems = listOf(
            "Sertifikat Keaslian" to "Cek verifikasi dan lisensi karya perajin lokal",
            "Ajukan Custom Order" to "Pesan kerajinan khusus sesuai keinginanmu",
            "Daftar Jadi Perajin" to "Bergabung dan jual karya kriyamu di KriyaKu",
            "Pengaturan Akun" to "Kelola profil, alamat pengiriman, dan keamanan",
            "Pusat Bantuan" to "Pertanyaan umum dan layanan bantuan pengguna",
            "Syarat & Ketentuan" to "Aturan penggunaan dan kebijakan privasi aplikasi"
        )
        menuItems.forEach { (title, desc) ->
            val row = ItemProfileMenuBinding.inflate(
                layoutInflater, binding.menuContainer, false
            )
            row.tvMenuTitle.text = title
            row.tvMenuDesc.text = desc
            row.root.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Kamu memilih: $title",
                    Toast.LENGTH_SHORT
                ).show()
            }
            binding.menuContainer.addView(row.root)
        }

        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Fitur edit profil segera hadir",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()

                    val intent = Intent(requireContext(), LoginActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
