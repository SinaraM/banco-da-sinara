package com.bancodasinara.events

import com.bancodasinara.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
    source: Any,
    val purchaseModel: PurchaseModel
):ApplicationEvent(source)