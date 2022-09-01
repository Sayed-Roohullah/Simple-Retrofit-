package com.roohi.simple_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.roohi.simple_retrofit.adapter.CountryListAdapter
import com.roohi.simple_retrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter : CountryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /////apikey/// 07b78190c5494c158a38ed978f365444
        initRecyclerView()
        initViewModel()
    }
    fun initRecyclerView(){
        countryListRecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CountryListAdapter(this)
        countryListRecyclerview.adapter = recyclerAdapter

    }
    private fun initViewModel(){
        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }
}