package com.eshc.travelplatform.ui.recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ActivityRecommnedBinding
import com.eshc.travelplatform.ui.MainActivity

class RecommendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecommnedBinding
    private var currentViewIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recommned)

        binding.ivBack.setOnClickListener {
            backToPrevious()
        }
        binding.next.setOnClickListener {
            goToNext()
        }
        binding.ivClose.setOnClickListener {
            startMainActivity()
        }
        binding.tvCancel.setOnClickListener {
            startMainActivity()
        }
    }
    private fun startMainActivity() {
        startActivity(Intent(this@RecommendActivity, MainActivity::class.java))
        finish()
    }
    private fun goToNext(){
        when(currentViewIndex){
            0 -> {
                binding.clWho.visibility = View.GONE
                binding.clStyle.visibility = View.VISIBLE
                currentViewIndex += 1
            }
            1 -> {
                binding.clStyle.visibility = View.GONE
                binding.clHowlong.visibility = View.VISIBLE
                currentViewIndex += 1
            }
            2 -> {

            }
        }
    }
    private fun backToPrevious(){
        when(currentViewIndex){
            1 -> {
                binding.clStyle.visibility = View.GONE
                binding.clWho.visibility = View.VISIBLE
                binding.ivBack.visibility = View.GONE
                currentViewIndex -= 1
            }
            2 -> {
                binding.clHowlong.visibility = View.GONE
                binding.clStyle.visibility = View.VISIBLE
                currentViewIndex -= 1
            }
        }
    }
}