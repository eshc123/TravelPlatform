package com.eshc.travelplatform.shared.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.eshc.travelplatform.R

object DialogUtil {
    fun showEditDialog(context: Context, title:String, limit: Int = 0, ok: (() -> Unit)? = null ){
        AlertDialog.Builder(context, R.style.AlertDialogTheme)
            .setView(R.layout.dialog_edit)
            .show()
            .also { alertDialog ->
                if(alertDialog == null) {
                    return@also
                }
                val btnOk = alertDialog.findViewById<AppCompatButton>(R.id.btn_ok)
                val tvTitle = alertDialog.findViewById<AppCompatTextView>(R.id.tv_title)
                val tvCancel = alertDialog.findViewById<AppCompatTextView>(R.id.tv_cancel)
                val etContent = alertDialog.findViewById<AppCompatEditText>(R.id.et_content)

                tvTitle?.text = title

                btnOk?.setOnClickListener {
                    if (ok != null) {
                        ok()
                    }
                    alertDialog.dismiss()
                }
                tvCancel?.setOnClickListener {
                    alertDialog.dismiss()
                }

            }
    }
}