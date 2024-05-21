package com.bancodasinara.exception

import com.bancodasinara.controller.response.ErrorResponse
import com.bancodasinara.controller.response.FieldErrorResponde
import com.bancodasinara.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handlerNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.erorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handlerBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.erorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ex.message,
            Errors.BS001.code,
            ex.bindingResult.fieldErrors.map { FieldErrorResponde(it.defaultMessage ?: "invalid", it.field)}
        )
        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}