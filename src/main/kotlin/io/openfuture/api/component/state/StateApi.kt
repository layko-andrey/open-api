package io.openfuture.api.component.state

import io.openfuture.api.domain.state.AccountDto
import io.openfuture.api.domain.state.StateTransactionDto
import io.openfuture.api.domain.state.WalletDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface StateApi {

    // accounts

    fun createAccount(webHook: String, address: String, blockchainId: Int): AccountDto

    fun getAccount(id: Long): AccountDto

    fun updateWebhook(accountId: Long, webHook: String): AccountDto

    fun deleteAccount(id: Long): AccountDto

    fun addWallet(accountId: Long, address: String, blockchainId: Int): AccountDto

    fun deleteWallet(accountId: Long, walletId: Long): AccountDto


    // wallets

    fun getAllByAccount(accountId: Long): List<WalletDto>

    fun getWallet(id: Long, accountId: Long): WalletDto


    // transactions

    fun getTransaction(id: Long, walletId: Long): StateTransactionDto

    fun getAllByWalletId(walletId: Long, pageRequest: Pageable): Page<StateTransactionDto>

}
