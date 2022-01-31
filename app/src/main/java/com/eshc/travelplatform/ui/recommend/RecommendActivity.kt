package com.eshc.travelplatform.ui.recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ActivityRecommnedBinding
import com.eshc.travelplatform.shared.util.adapter.ConditionAdapter
import com.eshc.travelplatform.ui.MainActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class RecommendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecommnedBinding
    private lateinit var recommendViewModel : RecommendViewModel
    private var currentViewIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recommned)
        recommendViewModel= ViewModelProvider(this, RecommendViewModelFactory())
            .get(RecommendViewModel::class.java)

        setLayoutManager()
        val whoAdapter = ConditionAdapter()
        binding.rvWho.adapter = whoAdapter
        val styleAdapter = ConditionAdapter()
        binding.rvStyle.adapter = styleAdapter

        recommendViewModel.conditionWho.observe(this, Observer {
            whoAdapter.replaceAll(it)
        })
        recommendViewModel.conditionStyle.observe(this, Observer {
            styleAdapter.replaceAll(it)
        })
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
                binding.ivBack.visibility = View.VISIBLE
                currentViewIndex += 1
            }
            1 -> {
                binding.ivBack.visibility = View.VISIBLE
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

    private fun setLayoutManager() {
        val whoFlexboxLayoutManager = FlexboxLayoutManager(this).apply {
            this.flexDirection = FlexDirection.ROW
            this.flexWrap = FlexWrap.WRAP
        }
        val styleFlexboxLayoutManager = FlexboxLayoutManager(this).apply {
            this.flexDirection = FlexDirection.ROW
            this.flexWrap = FlexWrap.WRAP
        }
        binding.rvWho.layoutManager = whoFlexboxLayoutManager
        binding.rvStyle.layoutManager = styleFlexboxLayoutManager
    }
}