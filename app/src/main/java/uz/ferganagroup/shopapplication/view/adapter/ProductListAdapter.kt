package uz.ferganagroup.shopapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import uz.ferganagroup.shopapplication.databinding.ProductItemBinding
import uz.ferganagroup.shopapplication.models.Product

class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.ItemHolder>() {
    var items: List<Product> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ItemHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.binding?.item = items.get(position)
        holder.binding?.executePendingBindings()
    }

    fun setData(items: List<Product>){
        this.items = items
        notifyDataSetChanged()
    }
    class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding: ProductItemBinding?
        init {
            binding = DataBindingUtil.bind(view)
        }
    }
}