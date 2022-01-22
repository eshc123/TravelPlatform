package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eshc.travelplatform.R
import com.eshc.travelplatform.shared.util.adapter.SpotAdapter
import com.eshc.travelplatform.data.plan.Spot
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.tabs.TabLayout


class PlanFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding: FragmentPlanBinding
    private lateinit var mapView: MapView
    private lateinit var recyclerView: RecyclerView
    private lateinit var tabLayout : TabLayout
    private val adapter by lazy { SpotAdapter().apply {
        setHasStableIds(true)
    } }

    private val views = mutableListOf<View>()

    val spots = listOf(
        Spot("서면",35.157529, 129.059315),
        Spot("광안대교",35.132803, 129.108314),
        Spot("해운대역",35.164039, 129.158778))

    override fun onMapReady(googleMap: GoogleMap) {
        var x = 0.0
        var y = 0.0
        spots.forEach {
            x += it.x
            y += it.y
            val marker = MarkerOptions()
                .position(LatLng(it.x,it.y))
                .title(it.name)
                .snippet("${it.name}입니다.")
            googleMap.addMarker(marker)
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(x /3,y/3)))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(12f))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plan, container, false)

        mapView = binding.map
        recyclerView = binding.rvSpots
        tabLayout = binding.tablayout

        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewsContainer()
        initTabLayout()
        initRecyclerView()
        test()
    }

    private fun test(){

        adapter.replaceAll(spots)
    }

    private fun initRecyclerView() {
        val lm = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        lm.scrollToPositionWithOffset(0, 0)

        recyclerView.layoutManager = lm
        recyclerView.adapter = adapter
    }

    private fun initTabLayout() {
        val tabNames = listOf("지도로 보기", "목록으로 보기")
        for (tabName in tabNames) {
            val newTab = tabLayout.newTab().setText(tabName)
            tabLayout.addTab(newTab)
        }
        setTabSelectedListener()
    }
    private fun setTabSelectedListener(){
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                views[tab.position].visibility = View.GONE
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                views[tab.position].visibility = View.VISIBLE
            }
        })
    }
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }
    private fun initViewsContainer() {
        views.add(mapView)
        views.add(recyclerView)
    }
}