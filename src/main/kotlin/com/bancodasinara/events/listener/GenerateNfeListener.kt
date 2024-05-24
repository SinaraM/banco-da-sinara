package com.bancodasinara.events.listener

import com.bancodasinara.events.PurchaseEvent
import com.bancodasinara.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListener(
    private val purchasrService: PurchaseService
) {
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        println("Gerando NFE")
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchasrService.update(purchaseModel)
    }
}