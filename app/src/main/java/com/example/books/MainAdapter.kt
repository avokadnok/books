package com.example.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_book.view.*

class MainAdapter(
    private val bookNames: List<String>
): RecyclerView.Adapter<CustomViewHolder>(){

    //numberOfItems
    override fun getItemCount(): Int {
        return bookNames.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //how do we even create a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.activity_book,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val bookNames = bookNames.get(position)
        holder.view.textView_bookname.text = bookNames
    }
}

class CustomViewHolder(val view :View):RecyclerView.ViewHolder(view){

}