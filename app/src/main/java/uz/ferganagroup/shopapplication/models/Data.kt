package uz.ferganagroup.shopapplication.models

import com.google.gson.annotations.SerializedName

class Data <T>{
    @SerializedName("error")
    var error: Boolean? = false
    @SerializedName("message")
    var message: String? = null
    @SerializedName("result")
    var result: T? = null
}