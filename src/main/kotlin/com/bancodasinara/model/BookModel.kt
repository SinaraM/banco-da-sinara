package com.bancodasinara.model

import com.bancodasinara.enums.BookStatus
import com.bancodasinara.enums.Errors
import com.bancodasinara.exception.BadRequestException
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
){

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
           if (field == BookStatus.CANCELADO || field == BookStatus.DELETADO)
               throw BadRequestException(Errors.BS102.message.format(field), Errors.BS102.code)

           field = value
        }

    constructor(id: Int? = null,
                name: String,
                price: BigDecimal,
                customer: CustomerModel? = null,
                status: BookStatus?): this(id, name, price, customer) {
    this.status = status
    }
}