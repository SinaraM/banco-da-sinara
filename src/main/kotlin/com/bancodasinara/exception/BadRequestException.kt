package com.bancodasinara.exception

class BadRequestException(override val message: String, val erorCode: String): Exception() {
}