package com.eshc.travelplatform.data.local.db

import com.eshc.travelplatform.data.local.db.entity.SpotEntity

class DataGenerator {
    companion object {
        fun getSpots(): List<SpotEntity>{
            return listOf(
                SpotEntity(name = "부산시청",address = "부산광역시 연제구",category = "관공서",x = 35.179792,y= 129.074881,image = "https://tong.visitkorea.or.kr/cms/resource/56/2716256_image2_1.jpg"),
                SpotEntity(name = "광안리 해수욕장",address = "부산광역시 수영구",category = "관광명소",x = 35.153659,y= 129.118537,image = "https://tong.visitkorea.or.kr/cms/resource/49/1994249_image2_1.jpg"),
                SpotEntity(name = "해운대 해수욕장",address = "부산광역시 해운대구",category = "관광명소",x = 35.158837,y= 129.160255,image = "https://tong.visitkorea.or.kr/cms/resource/86/1572286_image2_1.jpg"),
                SpotEntity(name = "기장 용궁사",address = "부산광역시 기장군",category = "관광명소",x = 35.188471,y= 129.223319,image = "https://tong.visitkorea.or.kr/cms/resource/92/565092_image2_1.jpg"),
                SpotEntity(name = "영화의 전당",address = "부산광역시 해운대구",category = "영화관",x = 35.171283,y= 129.127217,image = "https://tong.visitkorea.or.kr/cms/resource/36/1571036_image2_1.jpg"),
                SpotEntity(name = "다대포 해수욕장",address = "부산광역시 사하구",category = "관광명소",x = 35.047251,y= 129.966281,image = "https://tong.visitkorea.or.kr/cms/resource/50/1763850_image2_1.jpg")
            )
        }
    }
}
