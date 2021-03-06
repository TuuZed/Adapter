package com.tuuzed.androidx.recyclerview.adapter.prefs

import android.text.InputType
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.tuuzed.androidx.recyclerview.adapter.AbstractItemViewBinder
import com.tuuzed.androidx.recyclerview.adapter.CommonItemViewHolder


data class PrefEditTextItem(
        var title: String = "",
        var summary: String = "",
        var inputType: Int = InputType.TYPE_CLASS_TEXT,
        var hint: String? = null,
        var allowEmpty: Boolean = false,
        var maxLength: Int? = null,
        var callback: PrefItemCallback<PrefEditTextItem> = { _, _ -> true }
)

class PrefEditTextItemViewBinder : AbstractItemViewBinder<PrefEditTextItem>() {
    override fun getLayoutId() = R.layout.pref_listitem_edittext

    override fun onBindViewHolder(holder: CommonItemViewHolder, item: PrefEditTextItem, position: Int) {
        holder.text(R.id.tv_Title, item.title)
        holder.text(R.id.tv_Summary, item.summary)
        holder.click(R.id.itemLayout) {
            MaterialDialog(it.context).show {
                title(text = item.title)
                input(
                        hint = item.hint,
                        maxLength = item.maxLength,
                        prefill = item.summary,
                        inputType = item.inputType,
                        callback = { _, text ->
                            val oldSummary = item.summary
                            item.summary = text.toString()
                            if (item.callback(item, position)) {
                                holder.text(R.id.tv_Summary, item.summary)
                            } else {
                                item.summary = oldSummary
                            }
                        })
            }
        }
    }
}
