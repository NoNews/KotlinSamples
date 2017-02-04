package com.example.reg.kotlintest.activities


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.reg.kotlintest.R
import com.example.reg.kotlintest.adapters.DogListAdapter
import com.example.reg.kotlintest.models.Dog
import com.example.reg.kotlintest.models.Event
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe

class MainActivity : BaseActivity() {


    private val LAYOUT = R.layout.activity_main
    //
    private var dogs = mutableListOf<Dog>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)
        startBus()
        setupDogs()
        setupRecyclerView()
    }

    private fun setupDogs() {
        for (i in 1..20) dogs.add(Dog("Павел", i, "http://loveopium.ru/content/2016/01/haski/08s.jpg"))
    }


    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DogListAdapter(this, dogs)
    }


    @Subscribe
     fun onEvent(event: Event) {
        when (event.id) {
            Event.constants.OPEN_VIEW_PAGER_ACTIVITY ->showViewPagerActivity()
        }
    }


    private fun showViewPagerActivity() {
        Toast.makeText(this,"---------",Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        stopBus()
    }
}
