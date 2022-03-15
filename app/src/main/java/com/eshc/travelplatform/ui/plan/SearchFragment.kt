package com.eshc.travelplatform.ui.plan

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
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.shared.util.adapter.LocationCategoryAdapter
import com.eshc.travelplatform.shared.util.adapter.SpotSuggestionAdapter
import com.eshc.travelplatform.ui.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchViewModel : SearchViewModel
    private lateinit var kakaoMapView : MapView

    private var isUsingEmulator = true
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

        if(!isUsingEmulator) {
            kakaoMapView = MapView(activity)

            initMapView()
            (binding.mapview as ViewGroup).addView(kakaoMapView)

        }
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

        val suggestionAdapter = SpotSuggestionAdapter(this)
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
    fun addMarker(spotSuggestion: Spot){
        if(!isUsingEmulator) {
            kakaoMapView.removeAllPOIItems()
            val mapPoint = MapPoint.mapPointWithGeoCoord(
                spotSuggestion.point?.first ?: 35.161545,
                spotSuggestion.point?.second ?: 129.052049
            )
            val marker = MapPOIItem()
            marker.itemName = spotSuggestion.title
            marker.tag = 0
            marker.mapPoint = mapPoint
            marker.markerType = MapPOIItem.MarkerType.BluePin
            marker.selectedMarkerType = MapPOIItem.MarkerType.RedPin
            kakaoMapView.addPOIItem(marker)
            //kakaoMapView.moveCamera(CameraUpdateFactory.newMapPoint(mapPoint))
            kakaoMapView.setMapCenterPoint(mapPoint, false)
        }
        binding.etSearch.setText(spotSuggestion.title)
        binding.etSearch.clearFocus()
        hideKeyboard()
        openSearchDetailBottomSheet(spotSuggestion)
    }
    private fun initMapView(){
        val mapPoint = MapPoint.mapPointWithGeoCoord(35.179938,129.074901)
        kakaoMapView.setMapCenterPoint(mapPoint,false)

    }
    private fun openSearchDetailBottomSheet(spotSuggestion: Spot){
        val searchDetailFragment = SearchDetailFragment(spotSuggestion)
        searchDetailFragment.show(parentFragmentManager,this.tag)
    }
}