package com.eshc.travelplatform.ui.register

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentRegisterBinding
import com.eshc.travelplatform.shared.util.ext.afterTextChanged
import com.eshc.travelplatform.ui.MainActivity
import com.eshc.travelplatform.ui.recommend.RecommendActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BottomSheetDialogFragment() {

    private val registerViewModel by viewModels<RegisterViewModel>()
    private lateinit var binding: FragmentRegisterBinding
    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_register,container,false)
        binding.clContainer.maxHeight = WindowManager.LayoutParams.MATCH_PARENT
        (dialog as BottomSheetDialog).behavior.apply {
            peekHeight = (resources.displayMetrics.heightPixels * 0.9).toInt()
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val offsetFromTop = 200
        (dialog as BottomSheetDialog).behavior.apply {
           isFitToContents = true
           //expandedOffset = offsetFromTop
            //state = BottomSheetBehavior.STATE_EXPANDED
        }



        val username = binding.username
        val password = binding.password
        val phoneNum = binding.phonenum
        val register = binding.register
        val back = binding.back

        username.afterTextChanged {
            registerViewModel.registerDataChanged(
                username.text.toString(),
                password.text.toString(),
                phoneNum.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                registerViewModel.registerDataChanged(
                    username.text.toString(),
                    password.text.toString(),
                    phoneNum.text.toString()
                )
            }
        }
        phoneNum.apply {
            afterTextChanged {
                registerViewModel.registerDataChanged(
                    username.text.toString(),
                    password.text.toString(),
                    phoneNum.text.toString()
                )
            }
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        registerViewModel.register(
                            username.text.toString(),
                            password.text.toString(),
                            phoneNum.text.toString()
                        )
                }
                false
            }

            register.setOnClickListener {
                registerViewModel.register(username.text.toString(), password.text.toString(), phoneNum.text.toString())
                createDialog()
                this@RegisterFragment.dismiss()

            }
        }

        back.setOnClickListener {
            this.dismiss()
        }

        registerViewModel.registerFormState.observe(viewLifecycleOwner, Observer {
            val registerState = it ?: return@Observer

            register.isEnabled = registerState.isDataValid

            if (registerState.usernameError != null) {
                username.error = getString(registerState.usernameError)
            }
            if (registerState.passwordError != null) {
                password.error = getString(registerState.passwordError)
            }
            if  (registerState.phonenumError != null) {
                phoneNum.error = getString(registerState.phonenumError)
            }
        })

        registerViewModel.registerResult.observe(viewLifecycleOwner, Observer {
            val registerResult = it ?: return@Observer

            if (registerResult.error != null) {
                showRegisterFailed(registerResult.error)
            }
            if (registerResult.success != null) {
                // updateUiWithUser(loginResult.success)
            }

        })


    }
    private fun showRegisterFailed(@StringRes errorString: Int) {
        Toast.makeText(requireContext(), errorString, Toast.LENGTH_SHORT).show()
    }
    private fun createDialog(){
        AlertDialog.Builder(requireContext(),R.style.AlertDialogTheme)
            .setView(R.layout.dialog_welcome)
            .show()
            .also { alertDialog ->
                val mActivity = activity
                if(alertDialog == null) {
                    return@also
                }
                val planButton = alertDialog.findViewById<AppCompatTextView>(R.id.btn_plan)
                planButton?.setOnClickListener {
                    alertDialog.dismiss()
                    val recommendIntent = Intent(mActivity,RecommendActivity::class.java)
                    recommendIntent.putExtra("fromRegister",true)
                    mActivity?.startActivity(recommendIntent)
                    mActivity?.finish()
                }
                val justButton = alertDialog.findViewById<AppCompatTextView>(R.id.tv_just)
                justButton?.setOnClickListener {
                    alertDialog.dismiss()
                    mActivity?.startActivity(Intent(mActivity, MainActivity::class.java))
                    mActivity?.finish()
                }
            }
    }
}

