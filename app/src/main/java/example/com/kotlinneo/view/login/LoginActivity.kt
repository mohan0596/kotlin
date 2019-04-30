package example.com.kotlinneo.view.login


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import example.com.kotlinneo.view.BaseActivity
import example.com.kotlinneo.R
import example.com.kotlinneo.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_base.*

class LoginActivity : BaseActivity<LoginViewModel>() {


    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // Create the observer which updates the UI.
        viewModel.getLoginResponse().observe(this,Observer<LoginResponse>{
            if(it != null){
                hideLoading()
                mNavigator.navigateToDashboard(this)
                finish()
                Toast.makeText(this,it.data?.firstName,Toast.LENGTH_SHORT).show()
            }else{
                showErrorMessage("Error")
                hideLoading()
            }


        })

        btnLogin.setOnClickListener {
            if (viewModel.CheckValidation(txtEmail.text.toString(),txtPassword.text.toString())){
                viewModel.doLogin(txtEmail.text.toString(),txtPassword.text.toString())
                showLoading()
            }
            else
                Toast.makeText(this,"something went wrong",Toast.LENGTH_SHORT).show()


        }
    }





}
