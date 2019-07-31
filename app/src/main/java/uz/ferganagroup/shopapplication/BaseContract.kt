package uz.ferganagroup.shopapplication

import uz.ferganagroup.shopapplication.di.component.ApplicationComponent

class BaseContract {
    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
        fun inject(component: ApplicationComponent)
    }

    interface View{
        fun showProgress()
        fun hideProgress()
        fun showErrorSnackbar(message:String)
        fun showSuccessSnackbar(message: String)
        fun showInfoSnackbar(message: String)
    }
}