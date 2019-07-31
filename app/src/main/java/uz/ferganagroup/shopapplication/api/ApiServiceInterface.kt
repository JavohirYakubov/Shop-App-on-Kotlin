package uz.ferganagroup.shopapplication.api

import io.reactivex.Observable
import retrofit2.http.GET
import uz.ferganagroup.shopapplication.models.Data
import uz.ferganagroup.shopapplication.models.Product
import java.util.*

interface ApiServiceInterface{
    @GET("m9k75")
    fun getNews(): Observable<Data<List<Product>>>
}