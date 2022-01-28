package com.eshc.travelplatform.ui.plan

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentSearchBinding
import com.eshc.travelplatform.shared.util.adapter.LocationCategoryAdapter
import com.eshc.travelplatform.shared.util.adapter.RecommendationAdapter
import com.eshc.travelplatform.shared.util.adapter.SuggestionAdapter
import com.eshc.travelplatform.ui.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchViewModel : SearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchViewModel= ViewModelProvider(this, SearchViewModelFactory())
            .get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)


        //val kakaoMapView = net.daum.mf.map.api.MapView(activity)
        //(binding.mapview as ViewGroup).addView(kakaoMapView)

        binding.etSearch.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                binding.vBackground.visibility = View.VISIBLE
                binding.clList.visibility = View.VISIBLE
                (activity as MainActivity).findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.GONE
            }
            else {
                binding.vBackground.visibility = View.GONE
                binding.clList.visibility = View.GONE
                (activity as MainActivity).findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.VISIBLE
            }
        }
        binding.ivBack.setOnClickListener {
            binding.etSearch.clearFocus()
            hideKeyboard()
            back()
        }
        binding.ivClose.setOnClickListener {
            binding.etSearch.text?.clear()
            binding.etSearch.clearFocus()
            hideKeyboard()
        }

        val locationCategoryAdapter = LocationCategoryAdapter()
        binding.rvCategory.adapter = locationCategoryAdapter

        searchViewModel.categories.observe(viewLifecycleOwner, Observer {
            locationCategoryAdapter.replaceAll(it)
        })

        val suggestionAdapter = SuggestionAdapter()
        binding.rvSuggestion.adapter = suggestionAdapter
        searchViewModel.suggestions.observe(viewLifecycleOwner, Observer {
            suggestionAdapter.replaceAll(it)
        })

        return binding.root
    }
    private fun hideKeyboard(){
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etSearch.windowToken,0)
    }
    private fun back(){
        findNavController().popBackStack()
    }
}