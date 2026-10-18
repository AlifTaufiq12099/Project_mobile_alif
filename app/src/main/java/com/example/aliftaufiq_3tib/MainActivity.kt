package com.example.aliftaufiq_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aliftaufiq_3tib.databinding.ActivityMainBinding
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
        val user = intent.getStringExtra("Username")
        val pass = intent.getStringExtra("Password")
        val umur = intent.getIntExtra("Umur", 0 )

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
            MaterialAlertDialogBuilder(this)
                .setTitle("Log Out")
                .setMessage("Apakah anda yakin ingin keluar?")
                .setNegativeButton("tidak", null)
                .setPositiveButton("ya") { dialog, _ ->
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setCancelable(false)
                .show()

        }
        binding.btnlihat.setOnClickListener {

            val intent = Intent(this, activity_detail::class.java)
            startActivity(intent)
        }
        binding.btnkembali.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
            finish()
        }
    }
}