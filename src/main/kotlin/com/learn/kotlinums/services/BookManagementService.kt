package com.learn.kotlinums.services

import com.learn.kotlinums.enums.ServiceErrorCode
import com.learn.kotlinums.exceptions.ResourceNotAvailableException
import com.learn.kotlinums.models.Book
import com.learn.kotlinums.models.requests.UpdateBookRequest
import com.learn.kotlinums.repositories.BooksRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookManagementService(private val booksRepository: BooksRepository) {

    fun addBook(name: String, author: String) {
        val book = Book(UUID.randomUUID().toString(), name, author)
        booksRepository.addBook(book)
    }

    fun getBooks(): ArrayList<Book> {
        return booksRepository.getBooks()
    }

    fun findBookById(id: String): Book {
        val book = booksRepository.findById(id)
        book?.let { return it }
        throw ResourceNotAvailableException(ServiceErrorCode.BOOK_NOT_FOUND)
    }

    fun updateBook(id: String, updateBookRequest: UpdateBookRequest): Book {
        val book = booksRepository.findById(id) ?: throw ResourceNotAvailableException(ServiceErrorCode.BOOK_NOT_FOUND)

        book.name = updateBookRequest.name
        updateBookRequest.author?.let {
            book.author = updateBookRequest.author
        }
        booksRepository.upsert(book)
        return book
    }

    fun deleteBook(id: String) {
        booksRepository.delete(id)
    }

}