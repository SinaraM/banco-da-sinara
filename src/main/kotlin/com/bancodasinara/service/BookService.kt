package com.bancodasinara.service

import com.bancodasinara.model.BookModel
import com.bancodasinara.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }
}
