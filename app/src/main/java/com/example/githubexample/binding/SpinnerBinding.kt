package com.example.githubexample.binding

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

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
}
