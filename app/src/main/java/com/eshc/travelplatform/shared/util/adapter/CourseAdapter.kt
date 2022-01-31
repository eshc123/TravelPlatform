package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.domain.model.Course
import com.eshc.travelplatform.databinding.ItemCourseBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter

class CourseAdapter()  : BaseRecyclerViewAdapter<Course,ItemCourseBinding>(
    layoutResId = R.layout.item_course,
    bindingVariableId = BR.course
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemCourseBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}