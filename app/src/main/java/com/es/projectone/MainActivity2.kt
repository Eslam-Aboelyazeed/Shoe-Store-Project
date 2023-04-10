package com.es.projectone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}