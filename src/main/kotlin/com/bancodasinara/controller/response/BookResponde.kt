package com.bancodasinara.controller.response

import com.bancodasinara.enums.BookStatus
import com.bancodasinara.model.CustomerModel
import java.math.BigDecimal

data class BookResponde (

    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null

)
