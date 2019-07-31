package uz.ferganagroup.shopapplication.di.component

import dagger.Component
import uz.ferganagroup.shopapplication.api.ApiModule
import uz.ferganagroup.shopapplication.ui.main.MainActivity
import uz.ferganagroup.shopapplication.di.module.ApplicationModule
import uz.ferganagroup.shopapplication.ui.main.MainPresenter

@Component(modules = arrayOf(ApplicationModule::class, ApiModule::class))
interface ApplicationComponent{
    fun inject(activity: MainActivity)
    fun inject(presenter: MainPresenter)
}