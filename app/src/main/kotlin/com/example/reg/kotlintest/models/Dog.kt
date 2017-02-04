package com.example.reg.kotlintest.models

/**
 * Created by reg on 04.02.2017.
 */
class Dog {

    var name: String?
    var age: Int?
    var photo: String?

    constructor(name: String, age: Int, photo:String) {
        this.name = name
        this.age = age
        this.photo=photo
    }


}