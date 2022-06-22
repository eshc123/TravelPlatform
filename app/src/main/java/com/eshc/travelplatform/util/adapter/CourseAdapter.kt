package com.eshc.travelplatform.util.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.domain.model.Course
import com.eshc.travelplatform.databinding.ItemCourseBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter

class CourseAdapter(val fragment : Fragment)  : BaseRecyclerViewAdapter<Course,ItemCourseBinding>(
    layoutResId = R.layout.item_course,
    bindingVariableId = BR.course
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<ItemCourseBinding> {
        return super.onCreateViewHolder(parent, viewType).apply {
            this.itemView.setOnClickListener {
                //(fragment as PlanFragment).initScheduleBottomSheet()
            }
        }
    }
    override fun onBindViewHolder(holder: ViewHolder<ItemCourseBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}