package com.klinovvlad.designpatterns.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.klinovvlad.designpatterns.model.builders.ExampleBuilderClass
import com.klinovvlad.designpatterns.model.ExampleData
import com.klinovvlad.designpatterns.model.factories.ExampleDataFactory
import com.klinovvlad.designpatterns.model.ExampleDataHolder

class ExampleViewModel : ViewModel() {

    private val exampleMutableLiveData = MutableLiveData<List<ExampleData>>()
    val exampleLiveData: LiveData<List<ExampleData>>
        get() = exampleMutableLiveData

    val exampleBuilderClass: ExampleBuilderClass = ExampleBuilderClass.Builder("first")
        .secondString("second")
        .thirdString("third")
        .build()

    val exampleFactory = ExampleDataFactory.createSingleData(arrayListOf(0, 1, 2).random()).name

    fun getData() {
        exampleMutableLiveData.postValue(ExampleDataHolder.createData())
    }

}