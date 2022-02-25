package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.Course
import com.eshc.travelplatform.data.local.db.entity.DailyPlan
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyPlanDao {
    @Query("SELECT * FROM daily_plan_table")
    fun getDailyPlans() : Flow<List<DailyPlan>>
}