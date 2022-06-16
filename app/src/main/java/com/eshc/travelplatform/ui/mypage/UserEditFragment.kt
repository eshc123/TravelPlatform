package com.eshc.travelplatform.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentMypageBinding
import com.eshc.travelplatform.databinding.FragmentUserEditBinding
import com.eshc.travelplatform.shared.util.DialogUtil


class UserEditFragment : Fragment() {

    private val mypageViewModel: MypageViewModel by viewModels()
    private lateinit var binding: FragmentUserEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_edit, container, false)
        binding.fragment = this

        binding.clNicknameEdit.setOnClickListener {
            DialogUtil.showEditDialog(
                context = requireContext(),
                title = "닉네임 변경",
                limit = 10,
                ok = { Toast.makeText(requireContext(),"닉네임 변경 완료",Toast.LENGTH_SHORT).show() }
                )
        }

        binding.clPasswordEdit.setOnClickListener {
            DialogUtil.showEditDialog(requireContext(),
                "비밀번호 변경",
                limit = 10,
                ok = { Toast.makeText(requireContext(),"비밀번호 변경 완료",Toast.LENGTH_SHORT).show()}
                )
        }
        return binding.root
    }


}