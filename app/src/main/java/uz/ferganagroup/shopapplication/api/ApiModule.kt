package uz.ferganagroup.shopapplication.api

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.ferganagroup.shopapplication.utils.Constants
import javax.inject.Singleton


@Module
class ApiModule{
    @Provides
    fun provideApiService(gson: Gson, okHttpClient: OkHttpClient): ApiServiceInterface {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_HOST)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiServiceInterface::class.java)
    }

    @Provides
    fun provideGson(): Gson{
        return Gson()
    }

    @Provides
    fun provideOkClient(): OkHttpClient{
        return OkHttpClient()
    }
}