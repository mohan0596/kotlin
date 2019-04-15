package example.com.kotlinneo.view.login


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import example.com.kotlinneo.view.BaseActivity
import example.com.kotlinneo.R
import example.com.kotlinneo.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel>() {
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        // Create the observer which updates the UI.
        viewModel.getLoginResponse().observe(this,Observer<LoginResponse>{
            if(it != null){
                Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
            }else{
                showErrorMessage("Error")
            }


        })

        btnLogin.setOnClickListener {
            if (viewModel.CheckValidation(txtEmail.text.toString(),txtPassword.text.toString()))
                viewModel.doLogin(txtEmail.text.toString(),txtPassword.text.toString())
            else
                Toast.makeText(this,"something went wrong",Toast.LENGTH_SHORT).show()


        }


    }

}
