package com.example.aliftaufiq_3tib.More

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.aliftaufiq_3tib.LoginActivity
import com.example.aliftaufiq_3tib.R
import com.example.aliftaufiq_3tib.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!


    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript",
        "Dart", "Swift", "Go", "Ruby", "R",
        "PHP", "C#", "TypeScript", "Shell", "SQL",
        "Perl", "Rust", "Scala", "Haskell", "Lua",
        "Erlang", "Prolog", "Assembly", "Objective-C", "VBA"
    )
    private val dataListWithDesc = listOf(
        mapOf("title" to "Sertifikat Keaslian", "desc" to "Cek verifikasi dan lisensi karya perajin lokal"),
        mapOf("title" to "Ajukan Custom Order", "desc" to "Pesan kerajinan khusus sesuai keinginanmu"),
        mapOf("title" to "Daftar Jadi Perajin", "desc" to "Bergabung dan jual karya kriyamu di KriyaKu"),
        mapOf("title" to "Pengaturan Akun", "desc" to "Kelola profil, alamat pengiriman, dan keamanan"),
        mapOf("title" to "Pusat Bantuan", "desc" to "Pertanyaan umum dan layanan bantuan pengguna"),
        mapOf("title" to "Syarat & Ketentuan", "desc" to "Aturan penggunaan dan kebijakan privasi aplikasi")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "More"
        // Adapter: penghubung dataList dengan layout simple_list_item_1
//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )
//        // Hubungkan listViewItems dengan adapter
//        binding.listViewItems.adapter = adapter
//        // Aksi saat item diklik
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem",
//                Toast.LENGTH_SHORT).show()
//        }
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"), // key yang diambil dari data
            intArrayOf(android.R.id.text1, android.R.id.text2) // tempat tampilnya
        )
        binding.listViewItems.adapter = adapter
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)",
                Toast.LENGTH_SHORT).show()
        }
        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val pass = requireActivity().intent.getStringExtra("Pass")
        val umur = requireActivity().intent.getIntExtra("Umur", 0)
        val user = sharedPref.getString("username", "Pengguna")
        binding.btnLogout.setOnClickListener {
            // Pake requireContext()
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()

                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish() // Pake requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

}