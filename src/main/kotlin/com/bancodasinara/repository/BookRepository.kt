package com.bancodasinara.repository

import com.bancodasinara.model.BookModel
import com.bancodasinara.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int>{


}