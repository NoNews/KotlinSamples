package com.example.reg.kotlintest.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.reg.kotlintest.R
import com.example.reg.kotlintest.models.Dog
import com.example.reg.kotlintest.models.Event
import com.squareup.picasso.Picasso
import org.greenrobot.eventbus.EventBus

/**
 * Created by reg on 04.02.2017.
 */

class DogListAdapter() : RecyclerView.Adapter<DogListAdapter.DogHolder>() {


    val LAYOUT = R.layout.item_dog
    var context: Context? = null
    private var dogs = mutableListOf<Dog>()


    constructor(context: Context, dogs: MutableList<Dog>) : this() {
        this.context = context
        this.dogs = dogs
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DogHolder {
        val view = LayoutInflater.from(parent?.context).inflate(LAYOUT, parent, false)
        return DogHolder(view)
    }

    override fun onBindViewHolder(holder: DogHolder?, position: Int) {
        setupUI(holder, position)
        setupListeners(holder)

    }

    private fun setupListeners(holder: DogHolder?) {
        holder?.ltCard?.setOnClickListener { v -> EventBus.getDefault().post(Event(Event.constants.OPEN_VIEW_PAGER_ACTIVITY)) }
    }

    private fun setupUI(holder: DogHolder?, position: Int) {
        val dog = dogs[position]
        holder?.tvDogAge?.text = dog.age.toString()
        holder?.tvDogName?.text = dog.name
        Picasso.with(context).load(dog.photo).into(holder?.ivDogPhoto)
    }


    override fun getItemCount(): Int {
        return dogs.size
    }


    class DogHolder : RecyclerView.ViewHolder {

        var tvDogName: TextView
        var tvDogAge: TextView
        val ivDogPhoto: ImageView
        val ltCard: LinearLayout

        constructor(itemView: View) : super(itemView) {
            tvDogName = itemView.findViewById(R.id.tvDogName) as TextView
            tvDogAge = itemView.findViewById(R.id.tvDogAge) as TextView
            ivDogPhoto = itemView.findViewById(R.id.ivDogPhoto) as ImageView
            ltCard = itemView.findViewById(R.id.ltCard) as LinearLayout
        }

    }


}