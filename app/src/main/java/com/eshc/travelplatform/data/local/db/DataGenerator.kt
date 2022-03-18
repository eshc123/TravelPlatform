package com.eshc.travelplatform.data.local.db

import com.eshc.travelplatform.data.local.db.entity.SpotEntity

class DataGenerator {
    companion object {
        fun getSpots(): List<SpotEntity>{
            return listOf(
                SpotEntity(name = "부산시청",address = "부산광역시 연제구",category = "관공서",x = 35.179792,y= 129.074881,image = "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20191129102253613_thumbL"),
                SpotEntity(name = "광안리 해수욕장",address = "부산광역시 수영구",category = "관광명소",x = 35.153659,y= 129.118537,image = "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200313103238480_thumbL"),
                SpotEntity(name = "해운대 해수욕장",address = "부산광역시 해운대구",category = "관광명소",x = 35.158837,y= 129.160255,image = "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200827182111023_thumbL"),
                SpotEntity(name = "기장 용궁사",address = "부산광역시 기장군",category = "관광명소",x = 35.188471,y= 129.223319,image = "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20190516104119475_thumbL"),
                SpotEntity(name = "영화의 전당",address = "부산광역시 해운대구",category = "영화관",x = 35.171283,y= 129.127217,image = "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200326145708854_thumbL"),
                SpotEntity(name = "다대포 해수욕장",address = "부산광역시 사하구",category = "관광명소",x = 35.047251,y= 129.966281,image = "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200313110453239_thumbL")
            )
        }
    }
}
