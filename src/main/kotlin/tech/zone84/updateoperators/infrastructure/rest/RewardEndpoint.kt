package tech.zone84.updateoperators.infrastructure.rest

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import tech.zone84.updateoperators.domain.Domain
import tech.zone84.updateoperators.domain.UserNotFoundException
import tech.zone84.updateoperators.domain.shared.UserId

@RestController
@RequestMapping("/rewards")
class RewardEndpoint(private val domain: Domain) {
    @PostMapping("/purchased-services", consumes = [APPLICATION_JSON_VALUE])
    fun rewardPurchasedService(@RequestBody request: RewardPurchasedServiceRequest) {
        domain.rewardPurchase(RewardPurchasedServiceMapper.toDomain(request))
    }

    @GetMapping("/users/{userId}", produces = [APPLICATION_JSON_VALUE])
    fun findReward(@PathVariable userId: String): RewardResponse {
        return RewardMapper.fromDomain(domain.findReward(UserId.from(userId)))
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun userNotFoundError(exception: UserNotFoundException): String {
        return exception.message ?: ""
    }
}
