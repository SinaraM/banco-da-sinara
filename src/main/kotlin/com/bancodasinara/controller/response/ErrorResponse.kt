package com.bancodasinara.controller.response

data class ErrorResponse (
    var httpCode: Int,
    var message: String,
    var InternalCode: String,
    var errors: List<FieldErrorResponde>?
)