package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.data.plan.model.Recommendation
import com.eshc.travelplatform.data.plan.model.Spot

class RecommendViewModel : ViewModel() {
    private val _recommendations = MutableLiveData<MutableList<Recommendation>>()
    val recommendations: LiveData<MutableList<Recommendation>> = _recommendations
    init {
        _recommendations.value = mutableListOf(
            Recommendation("울산의 초록빛과 부산의 푸른빛에 둘려쌓여 자유를 만끽하다!","https://tong.visitkorea.or.kr/cms/resource/56/2716256_image2_1.jpg"),
            Recommendation("부산의 자연생태 체험 코스","https://tong.visitkorea.or.kr/cms/resource/49/1994249_image2_1.jpg"),
            Recommendation("부산 앞바다를 한눈에 아우르다","https://tong.visitkorea.or.kr/cms/resource/86/1572286_image2_1.jpg"),
            Recommendation("맛있는 부산의 남항시장 탐방","https://tong.visitkorea.or.kr/cms/resource/92/565092_image2_1.jpg"),
            Recommendation("기장 앞바다를 보며 힐링","https://tong.visitkorea.or.kr/cms/resource/36/1571036_image2_1.jpg"),
            Recommendation("부산의 아름다운 낮과 밤을 느끼는 주경, 야경 여행","https://tong.visitkorea.or.kr/cms/resource/50/1763850_image2_1.jpg"))
    }
}