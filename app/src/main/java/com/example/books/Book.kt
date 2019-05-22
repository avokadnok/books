package com.example.books

class Book {
    var id: Int = 0
    var authorName: String = ""
    var bookName: String = ""

    constructor(authorName: String, bookName: String) {
        this.authorName = authorName
        this.bookName = bookName
    }

    constructor() {
    }
}
