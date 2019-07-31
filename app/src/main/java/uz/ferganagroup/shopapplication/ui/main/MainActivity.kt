package uz.ferganagroup.shopapplication.ui.main

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.synnapps.carouselview.CarouselView
import uz.ferganagroup.shopapplication.R
import uz.ferganagroup.shopapplication.di.component
import uz.ferganagroup.shopapplication.models.Product
import uz.ferganagroup.shopapplication.view.adapter.ProductListAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var binding: uz.ferganagroup.shopapplication.databinding.ActivityMainBinding
    @Inject lateinit var context: Context
    @Inject lateinit var presenter: MainPresenter
    val newProductsAdapter: ProductListAdapter =
        ProductListAdapter()
    val topProductsAdapter: ProductListAdapter =
        ProductListAdapter()
    val moduleProductsAdapter: ProductListAdapter =
        ProductListAdapter()

    val sliderImages = arrayOf(R.drawable.arduino_uno, R.drawable.arduino_versions, R.drawable.rasberry_pi)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        component.inject(this)
        presenter.inject(component)
        presenter.attach(this)

        var slider = findViewById(R.id.slider) as CarouselView
        slider.pageCount = sliderImages.size
        slider.setImageListener { position, imageView ->
            imageView.setImageResource(sliderImages.get(position))
        }

        binding.recyclerViewNewProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewNewProducts.adapter = newProductsAdapter

        binding.recyclerViewTopProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewTopProducts.adapter = topProductsAdapter

        binding.recyclerViewModuleProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewModuleProducts.adapter = moduleProductsAdapter

        presenter.getHomeData()


    }


    override fun setDataList(items: List<Product>) {
        newProductsAdapter.setData(items)
        topProductsAdapter.setData(items)
        moduleProductsAdapter.setData(items)
    }

    override fun showProgress() {
        binding.isProgress = true
    }

    override fun hideProgress() {
        binding.isProgress = false
    }

    override fun showErrorSnackbar(message: String) {
        var snackbar = Snackbar.make(binding.slider, message, Snackbar.LENGTH_LONG)
        var view = snackbar.view
        view.setBackgroundColor(Color.RED)
        snackbar.show()
    }

    override fun showSuccessSnackbar(message: String) {
        var snackbar = Snackbar.make(binding.slider, message, Snackbar.LENGTH_LONG)
        var view = snackbar.view
        view.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        snackbar.show()

    }

    override fun showInfoSnackbar(message: String) {
        var snackbar = Snackbar.make(binding.slider, message, Snackbar.LENGTH_LONG)
        var view = snackbar.view
        view.setBackgroundColor(Color.BLUE)
        snackbar.show()
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

}
