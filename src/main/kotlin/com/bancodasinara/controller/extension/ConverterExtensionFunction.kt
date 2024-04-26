package com.bancodasinara.controller.extension

import com.bancodasinara.controller.request.PostBookRequest
import com.bancodasinara.controller.request.PostCustomerRequest
import com.bancodasinara.controller.request.PutBookRequest
import com.bancodasinara.controller.request.PutCustomerRequest
import com.bancodasinara.controller.response.BookResponde
import com.bancodasinara.controller.response.CustomerResponse
import com.bancodasinara.enums.BookStatus
import com.bancodasinara.enums.CustomerStatus
import com.bancodasinara.model.BookModel
import com.bancodasinara.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}
fun BookModel.toResponse(): BookResponde {
    return BookResponde(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}