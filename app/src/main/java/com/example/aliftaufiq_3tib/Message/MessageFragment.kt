package com.example.aliftaufiq_3tib.Message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import com.example.aliftaufiq_3tib.R
import com.example.aliftaufiq_3tib.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private val messageList = listOf(
        MessageModel("Alya", "Kak, tas anyaman rotan Lombok-nya masih ready stok?", "https://i.pravatar.cc/150?img=1"),
        MessageModel("Budi", "Bisa custom ukuran untuk kain tenun ikatnya nggak ya?", "https://i.pravatar.cc/150?img=2"),
        MessageModel("Citra", "Topeng ukir kayu jati ini bahannya pake jati tua kan Kak?", "https://i.pravatar.cc/150?img=3"),
        MessageModel("Dika", "Pesanan saya kira-kira kapan dikirim ya Kak?", "https://i.pravatar.cc/150?img=4"),
        MessageModel("Eka", "Kalo kirim ke luar pulau packing-nya aman nggak?", "https://i.pravatar.cc/150?img=5"),
        MessageModel("Fajar", "Cangkir keramik Kasongan kalau ambil 10 dapet diskon?", "https://i.pravatar.cc/150?img=6"),
        MessageModel("Gita", "Draft custom order #KRY-2408 udah saya setujui ya", "https://i.pravatar.cc/150?img=7"),
        MessageModel("Hana", "Makasih Kak, produknya udah sampe dan bagus banget!", "https://i.pravatar.cc/150?img=8"),
        MessageModel("Irfan", "Bisa minta tolong dibungkus pake kado sekalian Kak?", "https://i.pravatar.cc/150?img=9"),
        MessageModel("Joko", "Halo, pembayaran via transfer bank sudah saya selesaikan", "https://i.pravatar.cc/150?img=10")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}