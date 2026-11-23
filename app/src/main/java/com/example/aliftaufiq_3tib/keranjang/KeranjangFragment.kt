package com.example.aliftaufiq_3tib.keranjang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aliftaufiq_3tib.data.AppDatabase
import com.example.aliftaufiq_3tib.data.entity.CartEntity
import com.example.aliftaufiq_3tib.data.toRupiah
import com.example.aliftaufiq_3tib.databinding.FragmentKeranjangBinding
import kotlinx.coroutines.launch

class KeranjangFragment : Fragment() {

    private var _binding: FragmentKeranjangBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: CartAdapter
    private val cartItems = mutableListOf<CartEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKeranjangBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Keranjang Belanja"

        db = AppDatabase.getInstance(requireContext())
        adapter = CartAdapter(cartItems, ::deleteItem, ::increaseItem, ::decreaseItem)
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter

        binding.btnClear.setOnClickListener { clearCart() }

        loadCart()
    }

    override fun onResume() {
        super.onResume()
        if (_binding != null) loadCart()
    }

    private fun loadCart() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = db.cartDao().getAll()
            cartItems.clear()
            cartItems.addAll(result)
            adapter.notifyDataSetChanged()
            updateSummary()
        }
    }

    private fun updateSummary() {
        val total = cartItems.sumOf { it.price * it.quantity }
        binding.tvTotal.text = "Total: ${total.toRupiah()}"
        binding.tvEmpty.visibility = if (cartItems.isEmpty()) View.VISIBLE else View.GONE
        binding.rvCart.visibility = if (cartItems.isEmpty()) View.GONE else View.VISIBLE
    }

    private fun increaseItem(item: CartEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.cartDao().update(item.copy(quantity = item.quantity + 1))
            loadCart()
        }
    }

    private fun decreaseItem(item: CartEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            if (item.quantity <= 1) {
                db.cartDao().delete(item)
            } else {
                db.cartDao().update(item.copy(quantity = item.quantity - 1))
            }
            loadCart()
        }
    }

    private fun deleteItem(item: CartEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.cartDao().delete(item)
            loadCart()
        }
    }

    private fun clearCart() {
        viewLifecycleOwner.lifecycleScope.launch {
            db.cartDao().clear()
            loadCart()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
