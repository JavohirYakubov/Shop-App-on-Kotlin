package uz.ferganagroup.shopapplication.ui.main

import uz.ferganagroup.shopapplication.BaseContract
import uz.ferganagroup.shopapplication.models.Product

class MainContract {
    interface View: BaseContract.View{
        fun setDataList(items: List<Product>)
    }

    interface Presenter: BaseContract.Presenter<View>{
        fun getHomeData()
    }
}