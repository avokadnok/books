package com.example.books

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Books"
val COL_AUTHORNAME = "authorName"
val COL_BOOKNAME = "bookName"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY," +
                COL_AUTHORNAME + " text," +
                COL_BOOKNAME + " text)"
        db?.execSQL(createTable)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(book: Book) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_AUTHORNAME, book.authorName)
        cv.put(COL_BOOKNAME, book.bookName)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun readData(): MutableList<Book> {
        var list: MutableList<Book> = ArrayList()

        val db=this.readableDatabase
        val query="Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do{
                var book = Book()
                book.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                book.authorName = result.getString(result.getColumnIndex(COL_AUTHORNAME))
                book.bookName = result.getString(result.getColumnIndex(COL_BOOKNAME))
                list.add(book)
            }while(result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
}
