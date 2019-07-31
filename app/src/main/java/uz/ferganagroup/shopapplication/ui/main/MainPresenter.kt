package uz.ferganagroup.shopapplication.ui.main

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uz.ferganagroup.shopapplication.api.ApiServiceInterface
import uz.ferganagroup.shopapplication.di.component.ApplicationComponent
import uz.ferganagroup.shopapplication.models.Data
import uz.ferganagroup.shopapplication.models.Product
import javax.inject.Inject

class MainPresenter : MainContract.Presenter {

    private val subscribtions = CompositeDisposable()
    private lateinit var view: MainContract.View
    @Inject
    lateinit var api: ApiServiceInterface

    override fun inject(component: ApplicationComponent) {
        component.inject(this)
    }

    override fun getHomeData() {
        view.showProgress()
        subscribtions.add(
            Observable.zip(
                api.getNews(),
                api.getNews(),
                api.getNews(),
                Function3<Data<List<Product>>, Data<List<Product>>, Data<List<Product>>, Data<List<Product>>> { news, tops, modules ->
                    news
                }
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Data<List<Product>>>() {
                    override fun onNext(t: Data<List<Product>>) {
                        view.hideProgress()
                        if (t.error ?: false) {
                            view.showErrorSnackbar(t.message ?: "Error")
                        } else {
                            view.setDataList(t.result ?: emptyList())
                        }
                    }

                    override fun onError(e: Throwable) {
                        view.hideProgress()
                        view.showErrorSnackbar(e.localizedMessage)
                    }

                    override fun onComplete() {

                    }

                })
        )
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscribtions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }

}