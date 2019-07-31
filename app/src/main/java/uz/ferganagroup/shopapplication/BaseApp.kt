package uz.ferganagroup.shopapplication

import android.app.Application
import uz.ferganagroup.shopapplication.di.component.ApplicationComponent
import uz.ferganagroup.shopapplication.di.component.DaggerApplicationComponent
import uz.ferganagroup.shopapplication.di.module.ApplicationModule

class BaseApp : Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}