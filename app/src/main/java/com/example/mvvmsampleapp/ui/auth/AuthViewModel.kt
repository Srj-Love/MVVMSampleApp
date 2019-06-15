package com.example.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleapp.data.repositeries.UserRepository

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListner: AuthListener? = null

    // on login button Clicked
    fun onLoginButtonCLick(view: View) {
        authListner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListner?.onFailure("Invalid  ID Or Password")
            return
        }

        // TODO: we are creating here UserRepository() instances (bad practice), use Dependency Injection
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListner?.onSuccess(loginResponse)


    }
}