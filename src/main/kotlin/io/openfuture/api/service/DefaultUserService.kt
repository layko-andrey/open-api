package io.openfuture.api.service

import io.openfuture.api.entity.auth.User
import io.openfuture.api.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DefaultUserService(
        private val repository: UserRepository,
        private val openKeyService: OpenKeyService
) : UserService {

    @Transactional(readOnly = true)
    override fun findByGoogleId(googleId: String): User? = repository.findByGoogleId(googleId)

    @Transactional
    override fun save(user: User): User {
        val persistUser = repository.save(user)

        val openKey = openKeyService.generate(persistUser)

        persistUser.openKeys.add(openKey)

        return persistUser
    }

}