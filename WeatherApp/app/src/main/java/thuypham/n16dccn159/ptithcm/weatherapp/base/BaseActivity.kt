package thuypham.n16dccn159.ptithcm.weatherapp.base

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import thuypham.n16dccn159.ptithcm.weatherapp.ext.setAutoHideKeyboard

abstract class BaseActivity<ViewBinding : ViewDataBinding> : AppCompatActivity(){
    lateinit var viewBinding: ViewBinding

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this
        viewBinding.root.setAutoHideKeyboard(this)
        setUpToolbar()
        bindView()
        bindViewModel()
        setEvents()
    }

    open fun setUpToolbar() {}
    open fun toolbarFunc(curActivity: Activity?, toolbar: Toolbar?) {}
    open fun bindView() {}
    open fun setEvents() {}
    open fun updateUser() {}
    open fun bindViewModel() {}

    fun showToast(msg: String, typeToast: Int) {
        Toast.makeText(this, msg, typeToast).show()
    }
}