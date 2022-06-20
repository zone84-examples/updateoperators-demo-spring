package io.kotest.provided.sut

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import tech.zone84.updateoperators.infrastructure.rest.RewardPurchasedServiceRequest

@Service
class ApplicationClient {
    private val client: WebClient = WebClient.create("http://localhost:8000")

    fun postPurchasedService(request: RewardPurchasedServiceRequest): ClientResponse {
        return client.post()
            .uri("/rewards/purchased-services")
            .header("Content-type", MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(request), RewardPurchasedServiceRequest::class.java)
            .exchangeToMono { response -> Mono.just(response) }
            .block() ?: throw RuntimeException("Where's response?")
    }

    fun fetchReward(userId: String): ClientResponse {
        return client.get()
            .uri("/rewards/users/$userId")
            .header("Accept", MediaType.APPLICATION_JSON_VALUE)
            .exchangeToMono { response -> Mono.just(response) }
            .block() ?: throw RuntimeException("Where's response?")
    }
}
