package com.example.aliftaufiq_3tib.keranjang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aliftaufiq_3tib.data.entity.CartEntity
import com.example.aliftaufiq_3tib.data.toRupiah
import com.example.aliftaufiq_3tib.databinding.ItemCartBinding

class CartAdapter(
    private val items: List<CartEntity>,
    private val onDelete: (CartEntity) -> Unit,
    private val onPlus: (CartEntity) -> Unit,
    private val onMinus: (CartEntity) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            tvName.text = item.productName
            tvPrice.text = item.price.toRupiah()
            tvQty.text = item.quantity.toString()
            tvSubtotal.text = (item.price * item.quantity).toRupiah()
            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgProduct)
            btnPlus.setOnClickListener { onPlus(item) }
            btnMinus.setOnClickListener { onMinus(item) }
            btnDelete.setOnClickListener { onDelete(item) }
        }
    }

    override fun getItemCount(): Int = items.size
}
