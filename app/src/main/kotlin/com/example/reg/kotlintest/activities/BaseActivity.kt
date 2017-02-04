package com.example.reg.kotlintest.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

/**
 * Created by reg on 04.02.2017.
 */
open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun startBus() {
        EventBus.getDefault().register(this)
    }

    protected fun stopBus() {
        EventBus.getDefault().unregister(this)
    }

}