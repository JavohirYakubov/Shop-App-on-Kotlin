package uz.ferganagroup.shopapplication.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import uz.ferganagroup.shopapplication.ui.main.MainContract
import uz.ferganagroup.shopapplication.ui.main.MainPresenter

@Module
class ApplicationModule(private val application: Application){

    @Provides
    fun provideContext(): Context = application

    @Provides
    fun provideMainPresenter(): MainPresenter = MainPresenter()
}