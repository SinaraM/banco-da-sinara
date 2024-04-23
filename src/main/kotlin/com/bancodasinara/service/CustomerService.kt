package com.bancodasinara.service

import com.bancodasinara.controller.request.PostCustomerRequest
import com.bancodasinara.controller.request.PutCustomerRequest
import com.bancodasinara.model.CustomerModel
import com.bancodasinara.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service

class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {

        customerRepository.save(customer)
    }
    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)){
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)){
            throw Exception()
        }
        customerRepository.deleteById(id)
    }
}

