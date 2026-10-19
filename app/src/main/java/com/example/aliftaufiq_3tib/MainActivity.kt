package com.example.aliftaufiq_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aliftaufiq_3tib.Pertemuan5.LimaActivity
import com.example.aliftaufiq_3tib.databinding.ActivityMainBinding
import com.example.aliftaufiq_3tib.fragment.SixthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val pass = intent.getStringExtra("Pass")
        val umur = intent.getIntExtra("Umur", 0 )
        val user = sharedPref.getString("username", "Pengguna")



        Log.e("Hasil",  "Umur $umur")
        binding.textView3.text = "Selamat Datang, $user!\ndi Ekonomi Kreatif"
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Item dihapus",
                Snackbar.LENGTH_LONG)
                .setAction("BATAL") {
                    val intent = Intent(this, LoginActivity :: class.java)
                    startActivity(intent)
                }
                .show()
        }
        binding.AlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
        binding.btnlihat.setOnClickListener {

            val intent = Intent(this, activity_detail::class.java)
            startActivity(intent)
        }
        binding.btnlihatfragment.setOnClickListener {
            startActivity(Intent(this, SixthActivity::class.java))
        }
        binding.btnlihatweb.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))
        }

    }
}