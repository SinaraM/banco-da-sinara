package com.bancodasinara.controller.mapper

import com.bancodasinara.controller.request.PostPurchaseRequest
import com.bancodasinara.model.PurchaseModel
import com.bancodasinara.service.BookService
import com.bancodasinara.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}