package com.example.reg.kotlintest.models

/**
 * Created by reg on 04.02.2017.
 */
open class Event {



    object constants {
        val OPEN_VIEW_PAGER_ACTIVITY: Int = 1
    }

    var data = null
    var id: Int? = null

    constructor(data: Nothing?, id: Int?) {
        this.data = data
        this.id = id
    }

    constructor(id: Int?) {
        this.id = id
    }




}