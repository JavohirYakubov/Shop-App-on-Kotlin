package uz.ferganagroup.shopapplication.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import uz.ferganagroup.shopapplication.BR

class Product {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("imageUrl")
    var imageUrl: String? = null

    @SerializedName("price")
    var price: Double? = null
}