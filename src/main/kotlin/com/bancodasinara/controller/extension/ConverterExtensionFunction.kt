package com.bancodasinara.controller.extension

import com.bancodasinara.controller.request.PostBookRequest
import com.bancodasinara.controller.request.PostCustomerRequest
import com.bancodasinara.controller.request.PutCustomerRequest
import com.bancodasinara.enums.BookStatus
import com.bancodasinara.model.BookModel
import com.bancodasinara.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}
fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}