package com.es.projectone

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel(){


    private val _shoe: MutableLiveData<Shoe> = MutableLiveData(Shoe())
    val shoe: LiveData<Shoe>
        get() = _shoe

    private val _eventAdd = MutableLiveData<Boolean>()
    val eventAdd: LiveData<Boolean>
        get() = _eventAdd

    private val _eventCancel = MutableLiveData<Boolean>()
    val eventCancel: LiveData<Boolean>
        get() = _eventCancel

    private val _shoeList = MutableLiveData<String>("")
    val shoeList: LiveData<String>
        get() = _shoeList

    private val _theList = MutableLiveData<List<String>>()
    val thelist: LiveData<List<String>>
        get() = _theList

    fun addingShoe(){

        shoe.value?.let { _shoeList.value = makingTheList(it.name, it.company, it.ssize, it.description) }


        _theList.value = _theList.value?.toMutableList()?.plus(shoeList.value.toString()) ?: listOf(shoeList.value.toString())

    }

    fun makingTheList(newSName:String, newSCompany:String, newSSize:Double, newSDescription:String) : String =

        "The Shoe Name Is ${_shoe.value?.name}\nThe Company Is ${_shoe.value?.company}\nThe Size Is ${_shoe.value?.ssize.toString()}\nThe Description Is ${_shoe.value?.description}\n\n"


    fun reset(){
        _shoe.value = Shoe()
        _shoeList.value = ""
    }

    fun onAdd(){
        _eventAdd.value = true
    }

    fun onAddComplete(){
        _eventAdd.value = false
    }

    fun onCancel(){
        _eventCancel.value = true
    }

    fun onCancelComplete(){
        _eventCancel.value = false
    }

}