package uz.ferganagroup.shopapplication.di

import androidx.appcompat.app.AppCompatActivity
import uz.ferganagroup.shopapplication.BaseApp
import uz.ferganagroup.shopapplication.di.component.ApplicationComponent

val AppCompatActivity.component: ApplicationComponent
get() = (application as BaseApp).component