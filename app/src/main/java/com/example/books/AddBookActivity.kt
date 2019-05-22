package com.example.books

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_book.*

class AddBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        var db = DataBaseHandler(this)

        button_add_new_book.setOnClickListener {
            if (editText_add_author.text.toString().isNotEmpty() && editText_add_book.text.toString().isNotEmpty()) {
                var book = Book(editText_add_author.text.toString(), editText_add_book.text.toString())
                db.insertData(book)
            } else {
                Toast.makeText(this, "Please fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun cancelAddBook(view: View){
        val cancelAddBookIntent = Intent(this, MainActivity::class.java)
        startActivity(cancelAddBookIntent)
    }


    fun addNewBook(view: View){
        var book = Book(editText_add_author.text.toString(), editText_add_book.text.toString())
        val context = this
        var db = DataBaseHandler(context)
        db.insertData(book)
        val addNewBookIntent = Intent(this, MainActivity::class.java)
        startActivity(addNewBookIntent)
    }
}
