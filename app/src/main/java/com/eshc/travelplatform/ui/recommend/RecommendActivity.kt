package com.eshc.travelplatform.ui.recommend

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ActivityRecommnedBinding
import com.eshc.travelplatform.util.adapter.ConditionAdapter
import com.eshc.travelplatform.ui.MainActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class RecommendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecommnedBinding
    private val recommendViewModel : RecommendViewModel by viewModels()
    private var currentViewIndex = 0
    private var fromRegister = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fromRegister = intent.getBooleanExtra("fromRegister",false)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recommned)


        setLayoutManager()
        val whoAdapter = ConditionAdapter(context = this)
        whoAdapter.setHasStableIds(true)
        binding.rvWho.adapter = whoAdapter
        val styleAdapter = ConditionAdapter(this)
        styleAdapter.setHasStableIds(true)
        binding.rvStyle.adapter = styleAdapter

        recommendViewModel.conditionWho.observe(this) {
            whoAdapter.replaceAll(it)
        }
        recommendViewModel.conditionStyle.observe(this) {
            styleAdapter.replaceAll(it)
        }
        initSpinners()
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
        if(fromRegister)
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
                binding.ivBack.visibility = View.GONE
                binding.clHowlong.visibility = View.GONE
                binding.clWaiting.visibility = View.VISIBLE
                currentViewIndex += 1
                startAnimation()
            }
            3 -> {
                lifecycleScope.launch {
                    // TODO ?????? ????????? (32??? ?????? ?????? ??? ??????)
                    recommendViewModel.postItinerary(
                        title = "",
                        startDate = "${binding.spMonth.selectedItemPosition+1}???"+"${binding.spDate.selectedItemPosition+1}???",
                        endDate = "${binding.spMonth.selectedItemPosition+1}???"+"${binding.spDate.selectedItemPosition+1+binding.spNight.selectedItemPosition}???",
                        description = "",
                        period = binding.spNight.selectedItemPosition +1 )
                    finish()
                }

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
    private fun startAnimation(){
        val animationDrawable = binding.ivWaiting.background as AnimationDrawable
        animationDrawable.setExitFadeDuration(400)
        animationDrawable.setEnterFadeDuration(400)
        animationDrawable.start()
    }
    private fun initSpinners(){
        val months = resources.getStringArray(R.array.month)
        var dates = ArrayList<String>()
        val nights = resources.getStringArray(R.array.night)
        val calendar = Calendar.getInstance()
        val monthAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,months)
        val dateAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,dates)
        val nightAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,nights)
        binding.spMonth.adapter = monthAdapter
        binding.spDate.adapter = dateAdapter
        binding.spNight.adapter = nightAdapter
        binding.spMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                calendar.set(2022,position,1) // TODO ?????? ????????? ????????????
                dates = arrayListOf()
                for(i in 1 .. (calendar.getActualMaximum(Calendar.DAY_OF_MONTH))){
                    dates.add("${i}???")
                }
                dateAdapter.clear()
                dateAdapter.addAll(dates)
                dateAdapter.notifyDataSetChanged()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}