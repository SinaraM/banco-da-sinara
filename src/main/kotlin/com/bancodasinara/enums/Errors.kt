package com.bancodasinara.enums

enum class Errors(val code: String, val message: String) {

    BS001("BL-001", "Invalid Request"),
    BS101("BS-101", "Book [%s] not exists"),
    BS102("BS-102", "Cannot update book with status[%s] "),
    BS201("BL-201","Customer [%s] not exists")
}