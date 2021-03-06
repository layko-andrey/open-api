package io.openfuture.api.domain.event

import io.openfuture.api.component.web3.event.EventType
import io.openfuture.api.component.web3.event.EventType.PAID_FOR_SHARE_HOLDER
import java.math.BigDecimal

data class PaidForShareHolderEvent(
        val userAddress: String,
        val amount: BigDecimal
) : Event {

    override fun getType(): EventType = PAID_FOR_SHARE_HOLDER

}