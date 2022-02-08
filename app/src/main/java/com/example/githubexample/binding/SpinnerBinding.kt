package com.example.githubexample.binding

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object SpinnerBinding {

    // spinner에 값을 매핑하는 bindingAdapter
    @JvmStatic
    @BindingAdapter("entries")
    fun Spinner.setEntries( entries: Array<String>) {
        val entriesList = entries.asList()
        val arrayAdapter = ArrayAdapter(context, R.layout.simple_spinner_item, entriesList).apply {
            setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        }
        adapter = arrayAdapter
    }

    // attribute는 바인딩 어뎁터처럼 value을 의미한다. event는 반응할 bindingapdater의 value를 의미한다.
    //확장함수를 사용했다.
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    @JvmStatic
    fun Spinner.getSelectedValue(): Any? {
        return selectedItem
    }

    @JvmStatic
// 위에것이 실행되고 아래의 bindingapdater가 실행된다.
    @BindingAdapter("selectedValueAttrChanged")
    fun Spinner.InverseBindingListner(inverseBindingListener: InverseBindingListener?) {

        inverseBindingListener?.run {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    // 같을때 갱신할경우 무한루프에 빠지기 때문에 반드시 같을경우 갱신을 막는다.
                    if (tag != position) {
                        onChange()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
    }

    @JvmStatic
    @BindingAdapter("selectedValue")
    fun Spinner.setSelectedValue(selectedValue: Any?) {
        adapter?.run {
            val position = (adapter as ArrayAdapter<Any>).getPosition(selectedValue)
            setSelection(position, false)
            tag = position
        }
    }


}
