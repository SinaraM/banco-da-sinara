package com.bancodasinara.exception

class NotFoundException(override val message: String, val erorCode: String): Exception() {
}