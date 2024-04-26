package com.bancodasinara.repository

import com.bancodasinara.enums.BookStatus
import com.bancodasinara.model.BookModel
import com.bancodasinara.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>

}