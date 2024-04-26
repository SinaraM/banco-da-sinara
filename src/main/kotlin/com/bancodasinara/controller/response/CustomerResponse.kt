package com.bancodasinara.controller.response

import com.bancodasinara.enums.CustomerStatus

data class CustomerResponse (

    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus

)
