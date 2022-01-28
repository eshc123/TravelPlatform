package com.eshc.travelplatform.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eshc.travelplatform.MainApplication
import com.eshc.travelplatform.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            if(isLogin()){
                startMainActivity()
            }
            else
                startLoginActivity()
        }
    }
    private suspend fun isLogin() : Boolean {
       return MainApplication.getInstance().isLogin()
    }
    private fun startLoginActivity() {
        startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
        finish()
    }
    private fun startMainActivity() {
        startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        finish()
    }

}