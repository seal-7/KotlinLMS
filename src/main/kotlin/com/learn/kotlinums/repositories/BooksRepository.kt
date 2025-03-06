package com.learn.kotlinums.repositories

import com.learn.kotlinums.models.Book
import org.springframework.stereotype.Repository

@Repository
class BooksRepository(private val books: ArrayList<Book>) {

    fun addBook(book: Book) {
        books.add(book)
    }

    fun getBooks(): ArrayList<Book> {
        return books
    }

    fun findById(id: String): Book? {
        return books.firstOrNull { book: Book -> book.id == id }
    }

    fun upsert(book: Book) {
        books.indexOfFirst { it.id == book.id }
            .takeIf { it != -1 }
            ?.let { books[it] == book }
    }

    fun delete(id: String) {
        books.removeIf {it.id == id}
    }
}