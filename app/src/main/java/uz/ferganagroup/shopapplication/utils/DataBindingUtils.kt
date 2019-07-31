package uz.ferganagroup.shopapplication.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class DataBindingUtils {
    companion object{
        @BindingAdapter("setProductPrice")
        @JvmStatic
        fun setProductPrice(view: TextView, price: Double){
            if (price != null){
                view.setText("$price\$")
            }else{
                view.setText("none")
            }
        }

        @BindingAdapter("setImageFromUrl")
        @JvmStatic
        fun setImageFromUrl(view: ImageView, url: String){
            if (url == null)
                return
            Glide.with(view)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade(300))
                .into(view)
        }
    }
}