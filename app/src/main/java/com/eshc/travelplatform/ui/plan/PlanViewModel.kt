package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.data.repository.ItineraryRepositoryImpl
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.Course
import com.eshc.domain.model.Itinerary
import com.eshc.domain.model.Spot
import com.eshc.domain.usecase.itinerary.GetItinerariesUseCase
import com.eshc.domain.usecase.spot.GetPopularSpotsUseCase
import kotlinx.coroutines.launch

class PlanViewModel(spotRepositoryLocalImpl: SpotRepositoryLocalImpl, itineraryRepositoryImpl: ItineraryRepositoryImpl) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "일정 만들기"
    }
    val text: LiveData<String> = _text

    private val _recommendSpots = MutableLiveData<MutableList<Spot>>()
    val recommendSpots: LiveData<MutableList<Spot>> = _recommendSpots
    private val _courses = MutableLiveData<MutableList<Course>>()
    val courses: LiveData<MutableList<Course>> = _courses

    private val _itineraries = MutableLiveData<MutableList<Itinerary>>()
    val itineraries: LiveData<MutableList<Itinerary>> = _itineraries



    val getPopularSpots = GetPopularSpotsUseCase(spotRepositoryLocalImpl)
    val getItineraryUseCase = GetItinerariesUseCase(itineraryRepositoryImpl)
    init {
        viewModelScope.launch {
            _recommendSpots.value = getPopularSpots().toMutableList()
            _itineraries.value = getItineraryUseCase().toMutableList()

        }
            //mutableListOf(
//            Spot("울산의 초록빛과 부산의 푸른빛에 둘려쌓여 자유를 만끽하다!","https://tong.visitkorea.or.kr/cms/resource/56/2716256_image2_1.jpg"),
//            Spot("부산의 자연생태 체험 코스","https://tong.visitkorea.or.kr/cms/resource/49/1994249_image2_1.jpg"),
//            Spot("부산 앞바다를 한눈에 아우르다","https://tong.visitkorea.or.kr/cms/resource/86/1572286_image2_1.jpg"),
//            Spot("맛있는 부산의 남항시장 탐방","https://tong.visitkorea.or.kr/cms/resource/92/565092_image2_1.jpg"),
//            Spot("기장 앞바다를 보며 힐링","https://tong.visitkorea.or.kr/cms/resource/36/1571036_image2_1.jpg"),
//            Spot("부산의 아름다운 낮과 밤을 느끼는 주경, 야경 여행","https://tong.visitkorea.or.kr/cms/resource/50/1763850_image2_1.jpg")
//        )

        _courses.value = mutableListOf(
            Course("겨울 바다? 오히려 좋아","청사포 다릿돌전망대 → 송정 해수욕장 → 부산 롯데월드 → ...","https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=8de5fed1-5b7e-4078-8ec3-14c524629079"),
            Course("부산 먹거리는 못 참지","자갈치 시장 → 남포동 밀면→ 싸앗호떡 → 더 베이 101 → ","https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=936f2e57-f75c-41c8-acc0-d29dd494e73d"),
            Course("부산 먹거리는 못 참지","자갈치 시장 → 죄송합니다 → 부산 시장을 → 잘몰라요 → ","https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=936f2e57-f75c-41c8-acc0-d29dd494e73d")
        )
    }
}