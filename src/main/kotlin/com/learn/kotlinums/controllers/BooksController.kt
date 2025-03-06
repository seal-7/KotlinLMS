package com.learn.kotlinums.controllers

import com.learn.kotlinums.models.Book
import com.learn.kotlinums.models.requests.AddNewBookRequest
import com.learn.kotlinums.models.requests.UpdateBookRequest
import com.learn.kotlinums.services.BookManagementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/books"])
class BooksController(private val bookManagementService: BookManagementService) {

    @PostMapping
    fun addNewBook(@RequestBody addNewBookRequest: AddNewBookRequest): ResponseEntity<String> {
        bookManagementService.addBook(addNewBookRequest.name, addNewBookRequest.author)
        return ResponseEntity.ok("Book ${addNewBookRequest.name} added successfully!!")
    }

    @GetMapping
    fun getAllBooks(): ResponseEntity<ArrayList<Book>> {
        val books = bookManagementService.getBooks()
        return ResponseEntity.ok(books)
    }

    @GetMapping(value = ["/{id}"])
    fun getBookById(@PathVariable id: String): ResponseEntity<Book> {
        val book = bookManagementService.findBookById(id)
        return ResponseEntity.ok(book)
    }

    @PutMapping(value = ["/{id}"])
    fun updateBookById(@PathVariable id: String, @RequestBody updateBookRequest: UpdateBookRequest): ResponseEntity<Book> {
        val book = bookManagementService.updateBook(id, updateBookRequest)
        return ResponseEntity.ok(book)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteBookById(@PathVariable id: String):ResponseEntity<Unit> {
        bookManagementService.deleteBook(id)
        return ResponseEntity.ok().build()
    }
}

