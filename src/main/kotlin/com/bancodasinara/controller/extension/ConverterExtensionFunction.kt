package com.bancodasinara.controller.extension

import com.bancodasinara.controller.request.PostCustomerRequest
import com.bancodasinara.controller.request.PutCustomerRequest
import com.bancodasinara.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}
fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
